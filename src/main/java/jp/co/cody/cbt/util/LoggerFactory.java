/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.cody.cbt.util;

import java.io.InputStream;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import jp.co.cody.cbt.util.qualifier.LogQualifier;

/**
 *
 * @author satochuu
 */
@Dependent
public class LoggerFactory {

    static FileHandler fileHandler;

    static {
        InputStream is = null;
        try {
            Properties prop = new Properties();
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream("/logging.properties");
            prop.load(is);
            is.close();
            // GlassFishのデフォルトの情報を取得する
            LogManager defaults = LogManager.getLogManager();
            // ログファイル名
            String pattern = prop
                    .getProperty(
                            "java.util.logging.FileHandler.pattern",
                            defaults.getProperty("java.util.logging.FileHandler.pattern"));
            // 最大バイト数
            int limit = Integer
                    .parseInt(prop.getProperty(
                                    "java.util.logging.FileHandler.limit",
                                    defaults.getProperty("java.util.logging.FileHandler.limit")));
            // ログファイル数
            int count = Integer
                    .parseInt(prop.getProperty(
                                    "java.util.logging.FileHandler.count",
                                    defaults.getProperty("java.util.logging.FileHandler.count")));
            // 追加モード
            boolean append = Boolean
                    .parseBoolean(prop.getProperty(
                                    "java.util.logging.FileHandler.append",
                                    defaults.getProperty("java.util.logging.FileHandler.append")));

            // カスタマイズしたFileHandlerを新規作成
            fileHandler = new FileHandler(pattern, limit, count, append);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Resource(lookup = "java:app/AppName")
    String appName;                       // アプリケーション名がインジェクションされる

    public Logger getLogger(String name) {
        // ロガー名がappName+"."+nameになるようにする。
        Logger logger = Logger.getLogger(appName + "." + name);
        fileHandler.setFormatter(new MyLogFormatter());
        if (fileHandler != null) {
            logger.addHandler(fileHandler);
        }
        return logger;
    }

//    /**
//     *
//     * @param injectionPoint
//     * @return
//     * @throws Exception
//     */
//    @Produces
//    @LogQualifier(value = 1)
//    public Logger getLogger(InjectionPoint injectionPoint) throws Exception {
//        // インジェクション・ポイントにおけるクラスのパッケージ名を取得する。
//        String name = injectionPoint.getMember().getDeclaringClass()
//                .getPackage().getName();
//        return getLogger(name);
//    }
    @Inject
    InjectionPoint point;

    @Produces
    @LogQualifier(value = 0)
    public Logger getLogger0() {
        String className = point.getMember().getDeclaringClass().getName();
        Logger logger = getLogger(className);
        logger.setLevel(Level.ALL);
        return logger;
    }

    @Produces
    @LogQualifier(value = 1)
    public Logger getLogger1() {
        String className = point.getMember().getDeclaringClass().getName();
        
        Logger logger = getLogger(className);
        //logger.setLevel(Level.ALL);
        return logger;
    }
}
