package teamrapture.etherealalchemy.utils;

import net.minecraft.item.ItemStack;

import java.util.*;

public class ListUtils {

    public static boolean areListsEqual(List<ItemStack> one, List<ItemStack> two) {
        if (one == null && two == null) {
            return true;
        }

        if ((one == null && two != null)
                || one != null && two == null
                || one.size() != two.size()) {
            return false;
        }

        List<String> oneString = new ArrayList<>();
        for (ItemStack stack : one) {
            oneString.add(stack.getDisplayName());
        }


        List<String> twoString = new ArrayList<>();
        for (ItemStack stack : two) {
            twoString.add(stack.getDisplayName());
        }

        Collections.sort(oneString, String.CASE_INSENSITIVE_ORDER);
        Collections.sort(twoString, String.CASE_INSENSITIVE_ORDER);

        return equalLists(oneString, twoString);
    }

    public static boolean equalLists(List<String> one, List<String> two) {
        if (one == null && two == null) {
            return true;
        }

        if ((one == null && two != null)
                || one != null && two == null
                || one.size() != two.size()) {
            return false;
        }

        one = new ArrayList<String>(one);
        two = new ArrayList<String>(two);

        Collections.sort(one);
        Collections.sort(two);
        return one.equals(two);
    }
}
