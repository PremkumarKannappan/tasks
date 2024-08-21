package Task31;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class MapExample
{
    Map<String,String> exampleMap = new HashMap<>();
    public void addElements()
    {
        exampleMap.put("name","premkumar");
        exampleMap.put("age","21");
        exampleMap.put("Phone","9443931274");
        exampleMap.put("address","address");
        exampleMap.put("reg","962820104059");
    }
    public void printSetStream()
    {
        Stream streamExample = new Stream() {
            @Override
            public Stream filter(Predicate predicate) {
                return Stream.empty();
            }

            @Override
            public Stream map(Function mapper) {
                return Stream.empty();
            }

            @Override
            public IntStream mapToInt(ToIntFunction mapper) {
                return IntStream.empty();
            }

            @Override
            public LongStream mapToLong(ToLongFunction mapper) {
                return LongStream.empty();
            }

            @Override
            public DoubleStream mapToDouble(ToDoubleFunction mapper) {
                return DoubleStream.empty();
            }

            @Override
            public Stream flatMap(Function mapper) {
                return Stream.empty();
            }

            @Override
            public IntStream flatMapToInt(Function mapper) {
                return IntStream.empty();
            }

            @Override
            public LongStream flatMapToLong(Function mapper) {
                return LongStream.empty();
            }

            @Override
            public DoubleStream flatMapToDouble(Function mapper) {
                return DoubleStream.empty();
            }

            @Override
            public Stream distinct() {
                return Stream.empty();
            }

            @Override
            public Stream sorted() {
                return Stream.empty();
            }

            @Override
            public Stream sorted(Comparator comparator) {
                return Stream.empty();
            }

            @Override
            public Stream peek(Consumer action) {
                return Stream.empty();
            }

            @Override
            public Stream limit(long maxSize) {
                return Stream.empty();
            }

            @Override
            public Stream skip(long n) {
                return Stream.empty();
            }

            @Override
            public void forEach(Consumer action) {

            }

            @Override
            public void forEachOrdered(Consumer action) {

            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public Object[] toArray(IntFunction generator) {
                return new Object[0];
            }

            @Override
            public Object reduce(Object identity, BinaryOperator accumulator) {
                return null;
            }

            @Override
            public Optional reduce(BinaryOperator accumulator) {
                return Optional.empty();
            }

            @Override
            public Object reduce(Object identity, BiFunction accumulator, BinaryOperator combiner) {
                return null;
            }

            @Override
            public Object collect(Supplier supplier, BiConsumer accumulator, BiConsumer combiner) {
                return null;
            }

            @Override
            public Object collect(Collector collector) {
                return null;
            }

            @Override
            public Optional min(Comparator comparator) {
                return Optional.empty();
            }

            @Override
            public Optional max(Comparator comparator) {
                return Optional.empty();
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public boolean anyMatch(Predicate predicate) {
                return false;
            }

            @Override
            public boolean allMatch(Predicate predicate) {
                return false;
            }

            @Override
            public boolean noneMatch(Predicate predicate) {
                return false;
            }

            @Override
            public Optional findFirst() {
                return Optional.empty();
            }

            @Override
            public Optional findAny() {
                return Optional.empty();
            }

            @Override
            public Iterator iterator() {
                return null;
            }

            @Override
            public Spliterator spliterator() {
                return null;
            }

            @Override
            public boolean isParallel() {
                return false;
            }

            @Override
            public BaseStream sequential() {
                return null;
            }

            @Override
            public BaseStream parallel() {
                return null;
            }

            @Override
            public BaseStream unordered() {
                return null;
            }

            @Override
            public BaseStream onClose(Runnable closeHandler) {
                return null;
            }

            @Override
            public void close() {

            }
        }
    }
}
