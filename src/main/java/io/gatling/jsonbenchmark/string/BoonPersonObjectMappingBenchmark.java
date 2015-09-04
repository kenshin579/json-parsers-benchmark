
package io.gatling.jsonbenchmark.string;

import io.gatling.jsonbenchmark.string.model.Person;
import org.boon.json.JsonFactory;
import org.boon.json.ObjectMapper;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.logic.BlackHole;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.gatling.jsonbenchmark.bytes.Buffers.*;

@State
@BenchmarkMode(Mode.AverageTime)
public class BoonPersonObjectMappingBenchmark {

    ObjectMapper BOON_MAPPER = JsonFactory.create();

    private Object parsePersonClass(String str) throws Exception {
        return BOON_MAPPER.fromJson(str, Person.class);
    }

    private List parsePeopleList(String str) throws Exception {
        return BOON_MAPPER.readValue(str, List.class, Person.class);
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
