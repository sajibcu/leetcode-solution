class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        // Create a set to store the recipes that can be made
        Set<String> output = new HashSet<>();
        
        // Create a map to store available supplies and recipes that can be made
        Map<String, Boolean> spMap = new HashMap<>();
        
        // Populate the map with available supplies
        for (String s : supplies) {
            spMap.put(s, true);
        }
        
        // Iterate up to 100 times to ensure all possible recipes are checked
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < recipes.length; j++) {
                String r = recipes[j];
                
                // If the recipe is already in the output set, skip it
                if (!output.contains(r)) {
                    boolean isMake = true;
                    
                    // Check if all ingredients are available
                    for (String s : ingredients.get(j)) {
                        if (!Boolean.TRUE.equals(spMap.get(s))) {
                            isMake = false;
                            break;
                        }
                    }
                    
                    // If all ingredients are available, add the recipe to the output set
                    if (isMake) {
                        spMap.put(r, true);
                        output.add(r);
                    }
                }
            }
        }
        
        // Convert the output set to a list and return it
        return new ArrayList<String>(output);
    }
}
