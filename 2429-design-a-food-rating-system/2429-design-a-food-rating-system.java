class FoodRatings {

    // Map food -> Cuisine
    private final Map<String, String> foodToCuisine;
    // Map food -> Current Rating
    private final Map<String, Integer> foodToRating;

    //Map cuisine -> PriorityQueue of entries (ratings desc, name asc)
    private final Map<String, PriorityQueue<Entry>> cuisineToPQ;

    // Entry store in PQ
    private static class Entry{
        private String food;
        private int rating;
        Entry(String food, int rating){
            this.food = food;
            this.rating = rating;
        }
    }
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineToPQ = new HashMap<>();

        int n = foods.length;
        for(int i = 0; i < n; i++){
            String f = foods[i];
            String c = cuisines[i];
            int r = ratings[i];

            foodToCuisine.put(f, c);
            foodToRating.put(f, r);

            cuisineToPQ.computeIfAbsent(c, k -> new PriorityQueue<>(
                (a, b) -> {
                    if(a.rating != b.rating) return Integer.compare(b.rating, a.rating);  // higher rating first
                    return a.food.compareTo(b.food);   // lexigraphically smaller first
                }
            )).offer(new Entry(f,r));
        }
    }
    
    public void changeRating(String food, int newRating) {
        foodToRating.put(food, newRating);    // updated rating
        // push new entry for that cuisine
        String cuisine = foodToCuisine.get(food);
        PriorityQueue<Entry> pq = cuisineToPQ.get(cuisine);
        pq.offer(new Entry(food, newRating));
    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<Entry> pq = cuisineToPQ.get(cuisine);
        while(true){
            Entry top = pq.peek();
            if(top == null) return "";
            int currRating = foodToRating.get(top.food);
            if(top.rating == currRating){
                return top.food;
            }
            else{
                pq.poll();
            }
        }
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */