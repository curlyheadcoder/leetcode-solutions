class TaskManager {

    static class Info{
        int userId, priority;
        Info(int u, int p){
            userId = u;
            priority = p;
        }
    }
    static class Node{
        int priority, taskId;
        Node(int p, int id){
            priority = p;
            taskId = id;
        }
    }
    // Max-Heap : order byK/jok Priority desc, if tie then taskId desc
    private final PriorityQueue<Node> heap = new PriorityQueue<>(
        (a,b) -> {
            if(a.priority != b.priority) return Integer.compare(b.priority, a.priority);
            return Integer.compare(b.taskId, a.taskId);
        });
    private final Map<Integer, Info> map = new HashMap<>();
        
    public TaskManager(List<List<Integer>> tasks) {
        if(tasks != null){
            for(List<Integer> task : tasks){
                int u = task.get(0);
                int tid = task.get(1);
                int p = task.get(2);
                map.put(tid, new Info(u, p));
                heap.offer(new Node(p, tid));
            }
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        map.put(taskId, new Info(userId, priority));
        heap.offer(new Node(priority, taskId));
    }
    
    public void edit(int taskId, int newPriority) {
        Info curr = map.get(taskId);
        if(curr == null) return;
        curr.priority = newPriority;
        heap.offer(new Node(newPriority, taskId));
    }
    
    public void rmv(int taskId) {
        map.remove(taskId);
    }
    
    public int execTop() {
        while(!heap.isEmpty()){
            Node top = heap.poll();
            Info curr = map.get(top.taskId);
            if(curr == null) continue;
            if(curr.priority != top.priority) continue;
            map.remove(top.taskId);
            return curr.userId;
        }
        return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */