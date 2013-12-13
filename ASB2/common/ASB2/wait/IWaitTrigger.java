package ASB2.wait;

public interface IWaitTrigger {

    public void trigger(int id);

    public boolean shouldTick(int id);
}
