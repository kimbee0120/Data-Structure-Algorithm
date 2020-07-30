/***********************************************************************************************************************
 * Generate The Powerset
 * 
 * Given an input sequence arr, generate its power set.
 * A "power set" is the set of all subsets that can be formed from a sequence/set.
 * A set is a collection of distinct objects. A subset is a set that only contains elements found in the original set.
 * 
 * Input: [1, 2, 3]
 * Output:[
 * [], # the empty set
 * [1,2,3],
 * [1,2],
 * [1,3],
 * [1],
 * [2,3],
 * [2],
 * [3]
]
 */
public class GenerateThePowerset {
    public List<List<Integer>> generateThePowerSet(int[] inputSet)
    {
        List<List<Integer>> res = new ArrayList<>();

        generateSubset(0, inputSet, res, new ArrayList<>());

        return res;
    }

    private void generateSubset(int currIndex, int[] inputSet, List<List<Integer>> res, List<Integer> subsetsofar)
    {
        if(currIndex == inputSet.length){
            res.add(new ArrayList<>(subsetsofar));
        }

        subsetsofar.add(inputSet[currIndex]);
        generateSubset(currIndex+1, inputSet, res, subsetsofar);
        subsetsofar.remove(subsetsofar.size()-1);
        generateSubset(currIndex+1, inputSet, res, subsetsofar);
    }
}