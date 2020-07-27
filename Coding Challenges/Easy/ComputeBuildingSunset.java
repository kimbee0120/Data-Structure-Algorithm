/*******************************************************************************************************************************
 * Compute Buildings With A Sunset View
 * 
 * We are given an array buildings of integers. Each item represents the height of a building on a skyline from left to right.
 * Here are the details:
 * - The sun sits on the far left
 * - A building is "blocked" from seeing the sun if there is a building to its left that is >= in height than itself
 * 
 * You should:
 * Return a revised list of the buildings with "blocked" buildings excluded
 * Maintain the relative order of the buildings as they stood in buildings
 * Represent each building by its original index in buildings (rather than by its value)
 * 
 * Input: [11, 12, 13, 14, 15]
 * Output: [0, 1, 2, 3, 4]
 * Explanation: No building is blocked. All buildings stay.
 * 
 * Input:  [7, 4, 8, 2, 9]
 * Output: [0, 2, 4]
 * Explanation:
 * Building at index 1 (value 4) is blocked by building at index 0 (value 7) because 7 >= 4.
 * Building at index 3 (value 2) is blocked by building at index 2 (value 8) because 8 >= 2.
 * *******************************************************************************************************************************/
class ComputeBuildingSunset
{
    //use stack
    public List<Integer> getBuildingsWithAView(int[] buildings)
    {
        Stack<Integer> stack = new Stack<>();

        for(int i=buildings.length-1; i<=0; i--)
        {
            int curBuilding = buildings[i];

            while(!stack.isEmpty() && curBuilding > buildings[stack.peek()] )
            {
                stack.pop();
            }
            stack.push(i);
        }

        Collections.reverse(stack);
        return new ArrayList<>(stack);
    }

    //use ArrayList
    public List<Integer> getBuildingsWithAViewList(int[] buildings)
    {
        List<Integer> res = new ArrayList<>();
        int max = buildings[0];
        res.add(0);

        for(int i=1; i<buildings.length; i++)
        {
            int temp = buildings[i];
            if(temp > max){
                max = temp;
                res.add(i);
            }
        }

        return res;
    }
}