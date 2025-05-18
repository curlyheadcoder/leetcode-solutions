class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            String entry = "";
            if(i % 3 == 0) entry += "Fizz";
            if(i % 5 == 0) entry += "Buzz";
            if(entry.isEmpty()) entry = Integer.toString(i);
            answer.add(entry); 
        }
        return answer;
    }
}