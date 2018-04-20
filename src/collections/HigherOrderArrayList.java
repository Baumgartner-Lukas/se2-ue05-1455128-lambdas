package collections;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public final class HigherOrderArrayList<T> extends ArrayList<T> {

    HigherOrderArrayList() {
    }

    /**
     * Maps the elements of this list using a mapper function.
     *
     * @param mapper the function to map elements
     * @return the list of mapped elements
     */
    @Override
    public <R> List<R> map(Function<? super T, ? extends R> mapper) {
        List<R> mappedList = new HigherOrderArrayList<>();
        for (T elem : this) {
            mappedList.add(mapper.apply(elem));
        }
        return mappedList;
    }

    /**
     * Filters those elements of this list which pass the predicate test.
     * Filtered elements are returned in result list.
     *
     * @param predicate the predicate to test elements
     * @return the list of filtered elements
     */
    @Override
    public List<T> filter(Predicate<? super T> predicate) {
        List<T> filteredList = new HigherOrderArrayList<>();
        for (T elem : this) {
            if (predicate.test(elem)) {
                filteredList.add(elem);
            }
        }
        return filteredList;
    }

    /**
     * Performs the given action for each element of this list
     *
     * @param action
     */
    @Override
    public void forEach(Consumer<? super T> action) {
        for(T elem : this){
            action.accept(elem);
        }
    }

    /**
     * Reduces the elements to a single result using the
     * accumulator function and starting from an first value identity
     *
     * @param identity    the initial value for starting accumulating
     * @param accumulator the accumulator function
     * @return the final accumulated result
     */
    @Override
    public T reduce(T identity, BinaryOperator<T> accumulator) {
        T reducedList = null;
        for (T elem : this) {
            reducedList = accumulator.apply(identity, elem);
            identity = reducedList;
        }
        return reducedList;
    }
}
