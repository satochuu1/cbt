/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.cody.cbt.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
* シンプルなサンプルログフォーマッタ
*/
public class MyLogFormatter extends Formatter {
    private final SimpleDateFormat sdFormat 
        = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    public String format(final LogRecord argLogRecord) {
        final StringBuffer buf = new StringBuffer();

        buf.append(sdFormat.format(
            new Date(argLogRecord.getMillis())));
        buf.append(" ");
        buf.append(argLogRecord.getLevel());
/*
        if (argLogRecord.getLevel() == Level.FINEST) {
            buf.append("FINEST");
        } else if (argLogRecord.getLevel() == Level.FINER) {
            buf.append("FINER ");
        } else if (argLogRecord.getLevel() == Level.FINE) {
            buf.append("FINE ");
        } else if (argLogRecord.getLevel() == Level.CONFIG) {
            buf.append("CONFIG");
        } else if (argLogRecord.getLevel() == Level.INFO) {
            buf.append("INFO ");
        } else if (argLogRecord.getLevel() == Level.WARNING) {
            buf.append("WARN ");
        } else if (argLogRecord.getLevel() == Level.SEVERE) {
            buf.append("SEVERE");
        } else {
            buf.append(Integer.toString(argLogRecord.getLevel()
                .intValue()));
            buf.append(" ");
        }
        */
        buf.append(" ");
        buf.append(argLogRecord.getLoggerName());
        buf.append(" - ");
        buf.append(argLogRecord.getMessage());
        buf.append("\n");

        return buf.toString();
    }
}
