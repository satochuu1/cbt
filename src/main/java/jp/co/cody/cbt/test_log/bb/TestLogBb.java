/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.cody.cbt.test_log.bb;

import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import jp.co.cody.cbt.util.qualifier.LogQualifier;

/**
 *
 * @author satochuu
 */
@Named
@Dependent
public class TestLogBb {
//    @Inject
//    Logger log;
//
    @Inject @LogQualifier(value=0)
    Logger log;      // アプリケーション・ログ
//
//    @Inject @TraceLog
//    Logger traceLog;       // トレース・ログ
//
//    @Inject @SecurityLog
//    Logger securityLog; // セキュリティ・ログ 

    /**
     * Creates a new instance of TestLog
     */
    public TestLogBb() {
    }

    public String outputLog() {
        System.out.println("test");
        log.finest("finest");
        log.finer("finer:");
        log.fine("fine:");
        log.config("config:");
        log.info("info:");
        log.warning("warning:");
        log.severe("severe:");
        return "";
    }
}
