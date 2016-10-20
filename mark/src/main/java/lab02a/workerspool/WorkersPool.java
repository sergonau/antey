package lab02a.workerspool;

import java.util.HashMap;

import lab02a.common.IWorkRunnable;

/**
 * Created by Mark Lobanov on 20.10.2016.
 */
public class WorkersPool {
    private HashMap<WorkerKeyInfo, IWorkRunnable> workersMap = new HashMap<WorkerKeyInfo, IWorkRunnable>();

    public IWorkRunnable get(String key) {
        return workersMap.get(new WorkerKeyInfo( key ) );
    }

    public IWorkRunnable put(WorkerKeyInfo key, IWorkRunnable value) {
        return workersMap.put(key, value);
    }

    public void clear() {
        workersMap.clear();
    }
}
