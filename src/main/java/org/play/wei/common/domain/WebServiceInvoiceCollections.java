package org.play.wei.common.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Null safe utility class to manage collections
 */
public final class WebServiceInvoiceCollections {

  private WebServiceInvoiceCollections() {}

  /**
   * Get an immutable collection from the given collection
   *
   * @param <T>
   *          Type of this collection
   * @param collection
   *          input collection
   * @return An immutable collection
   */
  public static <T> Collection<T> immutable(Collection<T> collection) {
    if (collection == null) {
      return Set.of();
    }

    return Collections.unmodifiableCollection(collection);
  }

  /**
   * Get an immutable set from the given set
   *
   * @param <T>
   *          Type of this set
   * @param set
   *          input set
   * @return An immutable set
   */
  public static <T> Set<T> immutable(Set<T> set) {
    if (set == null) {
      return Set.of();
    }

    return Collections.unmodifiableSet(set);
  }

  /**
   * Get an immutable set from the given list
   *
   * @param <T>
   *          Type of this list
   * @param list
   *          input list
   * @return An immutable list
   */
  public static <T> List<T> immutable(List<T> list) {
    if (list == null) {
      return List.of();
    }

    return Collections.unmodifiableList(list);
  }
}
