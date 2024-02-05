package cdn;


import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @author laiw
 * @date 2024/1/23 15:14
 */
public class TestMap {

    /**
     * <eccu>
     *   <match:recursive-dirs value="dadd">
     *     <match:recursive-dirs value="ttest dddd">
     *       <revalidate>now</revalidate>
     *     </match:recursive-dirs>
     *   </match:recursive-dirs>
     * </eccu>
     *
     * <eccu>
     *   <match:recursive-dirs value="dadd">
     *     <match:recursive-dirs value="ttest dddd">
     *       <match:ext value="txt">
     *         <revalidate>now</revalidate>
     *       </match:ext>
     *     </match:recursive-dirs>
     *   </match:recursive-dirs>
     * </eccu>
     *
     */
    public static List<String> buildMataList(List<String> pathPatterns) {
        return buildMataList(groupByPaths(pathPatterns));
    }

    private static Map<String, Map<Integer, Set<String>>> groupByPaths(List<String> pathPatterns) {
        Map<String, Map<Integer, Set<String>>> mapMap = new HashMap<>();
        pathPatterns.forEach(e -> {
            String[] split;
            if (e.startsWith("/")) {
                split = e.substring(1).split("/");
            } else {
                split = e.split("/");
            }
            String root = split[0];
            if (!mapMap.containsKey(root)) {
                mapMap.put(root, new HashMap<>());
            }
            int length = split.length;
            if (length == 1) {
                return;
            }
            Map<Integer, Set<String>> rootMap = mapMap.get(root);
            for (int i = 1; i < length; i++) {
                Set<String> set;
                if (rootMap.containsKey(i)) {
                    set = rootMap.get(i);
                } else {
                    set = new LinkedHashSet<>();
                }
                set.add(split[i]);
                rootMap.put(i, set);
            }
        });
        return mapMap;
    }

    private static List<String> buildMataList(Map<String, Map<Integer, Set<String>>> mapMap) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Map<Integer, Set<String>>> entry : mapMap.entrySet()) {
            StringBuilder valueStr = new StringBuilder();
            StringBuilder endStr = new StringBuilder();
            Map<Integer, Set<String>> setMap = entry.getValue();
            for (Map.Entry<Integer, Set<String>> setEntry : setMap.entrySet()) {
                Set<String> dirs = new HashSet<>();
                Set<String> exts = new HashSet<>();
                setEntry.getValue().forEach(e -> {
                    if(e.contains("*.")) {
                        exts.add(e);
                    } else if(!e.equals("*")) {
                        dirs.add(e);
                    }
                });
                String extsValue = String.join(" ", exts);
                if(StringUtils.isNotBlank(extsValue)) {
                    extsValue = extsValue.replaceAll("\\*\\.", "");
                    valueStr.append("<match:ext value=\"").append(extsValue).append("\">");
                    valueStr.append("<revalidate>now</revalidate>");
                    valueStr.append("</match:ext>");
                }
                String dirsValue = String.join(" ", dirs);
                if(StringUtils.isNotBlank(dirsValue)) {
                    valueStr.append("<match:recursive-dirs value=\"").append(dirsValue).append("\">");
                    endStr.append("</match:recursive-dirs>");
                }
            }
            if(!valueStr.toString().endsWith("</match:ext>")) {
                valueStr.append("<revalidate>now</revalidate>");
            }
            valueStr.append(endStr);
            StringBuilder builder = new StringBuilder();
            builder.append("<eccu>")
                    .append("<match:recursive-dirs value=\"").append(entry.getKey()).append("\">")
                    .append(valueStr)
                    .append("</match:recursive-dirs>")
                    .append("</eccu>");
            result.add(builder.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> pathPatterns = new ArrayList<>();
        pathPatterns.add("/a/b/c");
        pathPatterns.add("/a/b1/c");
        pathPatterns.add("/d/b2/c");
        pathPatterns.add("/a/b/c/cdca");
        pathPatterns.add("/f/b/c/");
        pathPatterns.add("/a1/");
        pathPatterns.add("/a1/*");
        pathPatterns.add("/a1/*.jpg");
        pathPatterns.add("/a1/bb1/*.jpg");

        Map<String, Map<Integer, Set<String>>> mapMap = groupByPaths(pathPatterns);
        System.out.println(mapMap);

        List<String> list = buildMataList(mapMap);
        for (String s : list) {
            System.out.println(s);
        }

    }
}
