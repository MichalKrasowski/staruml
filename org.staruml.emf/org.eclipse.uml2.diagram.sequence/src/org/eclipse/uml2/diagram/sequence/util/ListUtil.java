package org.eclipse.uml2.diagram.sequence.util;

import java.util.List;

public class ListUtil {

	public static <T> boolean endsWith(List<T> bigList, List<T> smallList) {
		if (bigList.size() < smallList.size()) {
			return false;
		}
		return bigList.subList(bigList.size() - smallList.size(), bigList.size()).equals(smallList);
	}

}
