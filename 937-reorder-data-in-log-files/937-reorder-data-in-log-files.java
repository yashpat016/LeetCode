class Solution {
    public String[] reorderLogFiles(String[] logs) {
        String[] res = new String[logs.length];
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();
        for(String log:logs){
            if(Character.isLetter(log.charAt(log.indexOf(" ") + 1)))
                letterLogs.add(log);
            else
                digitLogs.add(log);
        }
        letterLogs.sort((o1, o2) -> {
            int cmp = o1.substring(o1.indexOf(" ") + 1).compareTo(o2.substring(o2.indexOf(" ") + 1));
            if(cmp == 0) return o1.compareTo(o2);
            return cmp;
        });

        int i = 0;
        for(String log : letterLogs) res[i++] = log;
        for(String log : digitLogs) res[i++] = log;

        return res;
    }
}