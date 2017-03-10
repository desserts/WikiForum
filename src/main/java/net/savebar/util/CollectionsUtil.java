package net.savebar.util;

import java.util.*;

/**
 * 集合操作
 * Created by hxy on 4/21/16.
 */

public class CollectionsUtil {
    public static <T> List<T> emptyWrapper(final List<T> aList) {
        if (aList == null) {
            return new ArrayList<>();
        } else {
            return aList;
        }
    }

    public static <T> Collection<T> emptyWrapper(final Collection<T> aCollection) {
        if (aCollection == null) {
            return new ArrayList<>();
        } else {
            return aCollection;
        }
    }

    public static <T> Set<T> emptyWrapper(final Set<T> aSet) {
        if (aSet == null) {
            return new HashSet<>();
        } else {
            return aSet;
        }
    }

    public static <T> List<T> emptyWrapper(final T... aArray) {
        if (aArray == null) {
            return new ArrayList<>();
        } else {
            List<T> result = new ArrayList<>();
            result.addAll(Arrays.asList(aArray));
            return result;
        }
    }

    public static <T> boolean isEmpty(final Collection<T> collection) {
        return collection == null || collection.size() <= 0;
    }

    public static <T> boolean isEmpty(final T... collection) {
        return collection == null || collection.length <= 0;
    }

    public static <T> boolean isNotEmpty(final T... collection) {
        return !isEmpty(collection);
    }

    public static <T> boolean isNotEmpty(final Collection<T> collection) {
        return !isEmpty(collection);
    }


    /**
     * 取出list中的一段
     *
     * @param list      list
     * @param pageIndex pageIndex
     * @param pageSize  pageSize
     * @return List
     */
    public static <T> List<T> subList(List<T> list, int pageIndex, int pageSize) {
        if (list == null || list.size() == 0)
            return list;
        if (pageIndex <= 1 && pageSize > list.size())
            return list;
        int from = (pageIndex - 1) * pageSize;
        if (from >= list.size())
            return null;//from = list.size()-1;
        if (from < 0)
            return null;//from = 0;
        int to = from + pageSize;
        if (to < 0 || to >= list.size())
            to = list.size();
        return list.subList(from, to);
    }

}
