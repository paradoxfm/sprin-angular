package ru.megazlo.springtest.utils;

import java.lang.management.ManagementFactory;

/**
 * @author paradoxfm - 02.09.2015
 */
public final class GlobalUtil {

    /**
     * Проверна на то что кто-то подключен в режиме отладки
     *
     * @return режим отладки
     */
    public static boolean isDebug() {
        return ManagementFactory.getRuntimeMXBean().getInputArguments().toString().contains("jdwp");
    }
}
