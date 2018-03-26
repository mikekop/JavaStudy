package ru.logrocon.lesson7;

public class DeadLock  implements ru.logrocon.lesson7.Process {
    public void start() {
        final ru.logrocon.lesson7.Item egg = new ru.logrocon.lesson7.Item("яйцо");
        final ru.logrocon.lesson7.Item chicken = new ru.logrocon.lesson7.Item("курица");
        new Thread(() -> egg.bow(chicken)).start();
        new Thread(() -> chicken.bow(egg)).start();
    }
}