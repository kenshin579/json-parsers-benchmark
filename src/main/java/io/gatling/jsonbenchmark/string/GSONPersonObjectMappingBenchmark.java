
package io.gatling.jsonbenchmark.string;

import com.google.gson.Gson;
import io.gatling.jsonbenchmark.string.model.Person;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.logic.BlackHole;

import java.util.concurrent.TimeUnit;

import static io.gatling.jsonbenchmark.bytes.Buffers.*;

@BenchmarkMode(Mode.AverageTime)
public class GSONPersonObjectMappingBenchmark {

    private static final Gson GSON_MAPPER = new Gson();

    private Object parsePersonClass(String str) throws Exception {
        return GSON_MAPPER.fromJson(str, Person.class);
    }

    private Object[] parsePeopleList(String str) throws Exception {
        return GSON_MAPPER.fromJson(str, Person[].class);
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void person_255bytes(BlackHole bh) throws Exception {
        bh.consume(parsePersonClass(STR_PERSON_255BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void person_100kb(BlackHole bh) throws Exception {
        bh.consume(parsePeopleList(STR_PERSON_100KBYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void person_1mb(BlackHole bh) throws Exception {
        bh.consume(parsePeopleList(STR_PERSON_1MBYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void person_5mb(BlackHole bh) throws Exception {
        bh.consume(parsePeopleList(STR_PERSON_5MBYTES));
    }
}
