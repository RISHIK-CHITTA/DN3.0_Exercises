// Command.java
interface CommandPatternExample {
    void execute();
}

// LightOnCommand.java
class TurnOnLightCommand implements CommandPatternExample {
    private Light light;

    public TurnOnLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

// LightOffCommand.java
class TurnOffLightCommand implements CommandPatternExample {
    private Light light;

    public TurnOffLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

// RemoteControl.java
class RemoteControl {
    private CommandPatternExample command;

    public void setCommand(CommandPatternExample command) {
        this.command = command;
    }

    public void pressButton() {
        if (command != null) {
            command.execute();
        }
    }
}

// Light.java
class Light {
    public void turnOn() {
        System.out.println("The light is on.");
    }

    public void turnOff() {
        System.out.println("The light is off.");
    }
}

// TestCommandPattern.java
class TestCommandPattern {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();
        CommandPatternExample turnOn = new TurnOnLightCommand(livingRoomLight);
        CommandPatternExample turnOff = new TurnOffLightCommand(livingRoomLight);
        RemoteControl remote = new RemoteControl();

        remote.setCommand(turnOn);
        remote.pressButton();

        remote.setCommand(turnOff);
        remote.pressButton();
    }
}
