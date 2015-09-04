
package io.gatling.jsonbenchmark.string;

import org.boon.json.JsonParser;
import org.boon.json.JsonParserFactory;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.logic.BlackHole;

import java.util.concurrent.TimeUnit;

import static io.gatling.jsonbenchmark.bytes.Buffers.*;

@State
@BenchmarkMode(Mode.AverageTime)
public class MainBoonBenchmark {

    private final JsonParser parser = new JsonParserFactory ().create ();

    private Object parse(String str) throws Exception {
        return parser.parse ( str );
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void actionLabel(BlackHole bh) throws Exception {
        bh.consume(parse(STR_ACTION_LABEL_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void citmCatalog(BlackHole bh) throws Exception {
        bh.consume(parse(STR_CITM_CATALOG_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void medium(BlackHole bh) throws Exception {
        bh.consume(parse(STR_MEDIUM_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void menu(BlackHole bh) throws Exception {
        bh.consume(parse(STR_MENU_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void sgml(BlackHole bh) throws Exception {
        bh.consume(parse(STR_SGML_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void small(BlackHole bh) throws Exception {
        bh.consume(parse(STR_SMALL_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void webxml(BlackHole bh) throws Exception {
        bh.consume(parse(STR_WEBXML_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void widget(BlackHole bh) throws Exception {
        bh.consume(parse(STR_WIDGET_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void webCalc_7MB(BlackHole bh) throws Exception {
        bh.consume(parse(STR_WEBCALC_ACTION_7MB));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void webCalc_100KB(BlackHole bh) throws Exception {
        bh.consume(parse(STR_WEBCALC_ACTION_100KB));
    }
}
