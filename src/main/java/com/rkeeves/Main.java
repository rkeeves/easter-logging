package com.rkeeves;

import org.apache.logging.log4j.*;

import java.util.UUID;

public class Main {

    private static String[] lines = """
Zold erdoben jartam,
Kek ibolyat lattam,
El akart hervadni,
Szabad-e locsolni?
""".strip().split("\\n");

    private static Logger logger = LogManager.getLogger(Main.class.getName());

    @FunctionalInterface
    interface LogMethod{
        void log(Marker marker, String msg);
    }

    private static LogMethod[] logMethods = new LogMethod[] {
            logger::info,
            logger::warn,
            logger::error,
            logger::debug
    };

    private static final Marker QUESTION_MARKER = MarkerManager.getMarker("QUESTION");

    private static final Marker STATEMENT_MARKER = MarkerManager.getMarker("STATEMENT");

    public static void main(String[] args) throws InterruptedException {
        int count = (args.length < 1) ? 1 : Integer.parseInt(args[0]);
        count = count * lines.length;
        ThreadContext.put("id", UUID.randomUUID().toString());
        logger.debug("https://youtu.be/dQw4w9WgXcQ");
        for (int i = 0; i < count; i++) {
            ThreadContext.put("iter", Integer.toString(i));
            String msg = lines[i % lines.length];
            logMethods[i % logMethods.length].log(getMarkerForMessage(msg) ,msg);
            Thread.sleep(500);
        }
        ThreadContext.clearAll();
    }

    private static Marker getMarkerForMessage(String msg){
        return msg.endsWith("?") ? QUESTION_MARKER : STATEMENT_MARKER;
    }
}
