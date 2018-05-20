package springmybatis.order.pojo.designpattern;

abstract class Logger{
    protected Logger nextLogger;

    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public Logger getNextLogger() {
        return nextLogger;
    }

    abstract protected void log(String message);

    public void logMessage(String message){
        log(message);
        if(nextLogger != null){
            nextLogger.logMessage(message);
        }
    }
}

class ConsoleLogger extends Logger{
    @Override
    protected void log(String message) {
        System.out.println("Console::Logger: " + message);
    }
}

class EMailLogger extends Logger{
    @Override
    protected void log(String message) {
        System.out.println("Email Logger: " + message);
    }
}

class FileLogger extends Logger{
    @Override
    protected void log(String message) {
        System.out.println("File Logger: " + message);
    }
}


public class duty {
    public static Logger getChainOfLoggers(){
        Logger emailLogger = new EMailLogger();
        Logger fileLogger = new FileLogger();
        Logger consoleLogger = new ConsoleLogger();

        emailLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);
        return emailLogger;
    }

    public static void main(String[] args){
        Logger loggerChain = getChainOfLoggers();
        loggerChain.logMessage("Null pointer");
        loggerChain.logMessage("Array Index Out of Bound");
        loggerChain.logMessage("Illegal Parameters");
    }
}
