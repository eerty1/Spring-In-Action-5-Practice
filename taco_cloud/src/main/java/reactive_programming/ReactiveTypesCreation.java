package reactive_programming;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;


public class ReactiveTypesCreation {
    static Integer[] testIntegerArray = {1, 2, 3, 4};
    static List<String> testListOfStrings = Arrays.asList("123", "234", "456");
    static Stream<String> testStringStream = Stream.of("Test", "Value");
    Flux<String> fruitFlux = Flux.just("Apple", "Orange", "Grape");
    Mono<Integer> phoneNumberMono = Mono.just(441234567);

    public static void typeCreation() {
        ReactiveTypesCreation reactiveTypesCreation = new ReactiveTypesCreation();
        reactiveTypesCreation.fruitFlux.subscribe(t -> System.out.println("Here's the fruit flux: " + t));
        reactiveTypesCreation.phoneNumberMono.subscribe(i -> System.out.println("My phone number +375" + i));
    }

    public static void verifyWithStepVerifier() {
        ReactiveTypesCreation reactiveTypesCreation = new ReactiveTypesCreation();
        StepVerifier.create(reactiveTypesCreation.fruitFlux)
                .expectNext("Apple", "Orange", "Grape")
                .expectNext("Orange").expectNext("Grape")
                .verifyComplete();
    }

    public static void createTypeBy() {
        Flux<Integer> fluxFromIntegerArray = Flux.fromArray(testIntegerArray);
        fluxFromIntegerArray.subscribe(System.out::println);
        Flux<String> fluxFromStringArrayList = Flux.fromIterable(testListOfStrings);
        fluxFromStringArrayList.subscribe(System.out::println);
        Flux<String> fluxFromStream = Flux.fromStream(testStringStream);
        fluxFromStream.subscribe(System.out::println);
        StepVerifier.create(fluxFromIntegerArray)
                .expectNext(1)
                .expectNext(2)
                .expectNext(3)
                .expectNext(4)
                .verifyComplete();
    }

    public static void generateDataFromFlux() {
        Flux<Integer> fluxFromRange = Flux.range(1, 4);
        fluxFromRange.subscribe(System.out::println);
        StepVerifier.create(fluxFromRange)
                .expectNext(1)
                .expectNext(2)
                .expectNext(3)
                .expectNext(4)
                .verifyComplete();
        Flux<Long> fluxFromInterval = Flux.interval(Duration.ofSeconds(1));
        fluxFromInterval.subscribe(System.out::println);
        try {
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        StepVerifier.create(fluxFromInterval)
                .expectNext(0L)
                .expectNext(1L)
                .expectNext(2L)
                .expectNext(3L)
                .expectNext(4L)
                .verifyComplete();
    }

    public static void mergeFluxes() {
        Flux<String> characterFlux = Flux.just("Garfield", "Kojak", "Barbossa")
                .delayElements(Duration.ofMillis(500));
        Flux<String> foodFlux = Flux.just("Lasagna", "Lollipops", "Apples")
                .delaySubscription(Duration.ofMillis(250)).delayElements(Duration.ofMillis(500));
//        Flux<String> mergedFlux = characterFlux.mergeWith(foodFlux);
        Flux<String> mergedFlux = Flux.merge(characterFlux, foodFlux);
        mergedFlux.subscribe(System.out::println);
        StepVerifier.create(mergedFlux)
                .expectNext("Garfield")
                .expectNext("Lasagna")
                .expectNext("Kojak")
                .expectNext("Lollipops")
                .expectNext("Barbossa")
                .expectNext("Apples")
                .verifyComplete();
    }

    public static void zipFluxes() {
        Flux<String> characterFlux = Flux.just("Garfield", "Kojak", "Barbossa");
        Flux<String> foodFlux = Flux.just("Lasagna", "Lollipops", "Apples");
        Flux<String> zippedFlux = Flux.zip(characterFlux, foodFlux, (c, f) -> c + " eats " + f);
        StepVerifier.create(zippedFlux)
                .expectNext("Garfield eats Lasagna")
                .expectNext("Kojak eats Lollipops")
                .expectNext("Barbossa eats Apples")
                .verifyComplete();
    }

    public static void mergeFLuxWithMono() {
        Flux<String> stringFlux = Flux.just("FLUX", "FLUX2", "FLUX3");
        Mono<String> monoString = Mono.just("MONO");
        Flux<String> mergedFluxAndMono = stringFlux.mergeWith(monoString);
        mergedFluxAndMono.subscribe(System.out::println);
    }

    public static void findFirstOfTwo() {
        Flux<String> slowFlux = Flux.just("tortoise", "snail", "sloth");
        Flux<String> fastFlux = Flux.just("hare", "cheetah", "squirrel");
        Flux<String> firstFlux = Flux.first(slowFlux, fastFlux);
        firstFlux.subscribe(System.out::println);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void skipElements() {
        Flux<String> skipFlux = Flux.just("one", "two", "skip a few", "ninety nine", "one hundred")
                .delayElements(Duration.ofSeconds(1)).skip(Duration.ofSeconds(4));
        skipFlux.subscribe(System.out::println);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void filterElementsLogic() {
        Flux<String> nationalParkFlux = Flux.just("Yellowstone", "Yosemite", "Grand Canyon", "Zion", "Grand Teton")
                .filter(predicate -> !predicate.contains(" "));
        nationalParkFlux.subscribe(System.out::println);
    }

    public static void distinctElements() {
        Flux<String> animalFlux = Flux.just("dog", "cat", "bird", "dog", "bird", "anteater").distinct();
        animalFlux.subscribe(System.out::println);
    }

    public static void mapping() {
        Flux<Player> playerFlux = Flux.just("Michael Jordan", "Scottie Pippen", "Steve Kerr")
                .map(n -> {
                    String[] split = n.split("\\s");
                    return new Player(split[0], split[1]);
                }).subscribeOn(Schedulers.parallel());
        playerFlux.subscribe(System.out::println);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void flatMapping() {
        Flux<Player> playerFlux = Flux.just("Michael Jordan", "Scottie Pippen", "Steve Kerr")
                .flatMap(n -> Mono.just(n)
                        .map(p -> {
                            String[] split = p.split("\\s");
                            return new Player(split[0], split[1]);
                        }));
        playerFlux.subscribe(System.out::println);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void bufferFruitInFlatMap() {
        Flux.just("apple", "orange", "banana", "kiwi", "strawberry")
                .buffer(3)
                .flatMap(x -> Flux.fromIterable(x)
                        .map(String::toUpperCase)
                        .subscribeOn(Schedulers.parallel())
                        .log())
                .subscribe(System.out::println);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void collectList() {
        Flux<String> fruit = Flux.just("orange", "grape", "pear", "strawberry");
        Mono<List<String>> fluxList = fruit.collectList();
        fluxList.subscribe(System.out::println);
    }

    public static void collectMap() {
        Flux<String> characters = Flux.just("Riki", "Mirana", "Death Prophet");
        Mono<Map<Character, String>> mapMono = characters.collectMap(x -> x.charAt(0));
        mapMono.subscribe(System.out::println);
    }

    public static void testIfAny() {
        Flux<String> musicians = Flux.just("50 Cent", "21 Savage", "Drake");
        Mono<Boolean> ifAny = musicians.any(x -> x.contains("a"));
        ifAny.subscribe(System.out::println);
        Mono<Boolean> ifAll = musicians.all(y -> y.contains("e"));
        ifAll.subscribe(System.out::println);
    }

    public static void main(String[] args) {
        testIfAny();
    }
}