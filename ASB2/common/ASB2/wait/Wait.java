package ASB2.wait;

public class Wait {
    
    long timeKeeper;
    long timeToWait;
    int id;
    IWaitTrigger thingToTrigger;
    
    public Wait(long timeToWait, IWaitTrigger thingToTrigger, int id) {
        
        this.timeToWait = timeToWait;
        this.thingToTrigger = thingToTrigger;
        this.id = id;
    }
    
    public Wait(IWaitTrigger thingToTrigger, long timeToWait, int id) {
        
        this.timeToWait = timeToWait;
        this.thingToTrigger = thingToTrigger;
        this.id = id;
    }
    
    public void setWaitTime(long newWaitTime) {
        
        this.timeToWait = newWaitTime;
    }
    
    public void update() {
        
        if (thingToTrigger != null) {
            
            if (thingToTrigger.shouldTick(id)) {
                
                timeKeeper++;
            }
        }
        
        if (timeKeeper >= timeToWait) {
            
            if (thingToTrigger != null) {
                
                thingToTrigger.trigger(id);
                timeKeeper = 0;
            }
        }
    }
    
    public long getRemainingTime() {
        
        return timeToWait - timeKeeper;
    }
}
