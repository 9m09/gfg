class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        return help(arr, 0, sum, new ArrayList<>());
    }

    static Boolean help(int arr[], int index, int sum, List<Integer> tlist) {
        if (index == arr.length) {
            return sum == 0;
        }

        if (arr[index] <= sum) {
            tlist.add(arr[index]);
            if (help(arr, index + 1, sum - arr[index], tlist)) {
                return true;
            }
            tlist.remove(tlist.size() - 1);  
        }

        if (help(arr, index + 1, sum, tlist)) {
            return true;
        }

        return false;
    }
}
