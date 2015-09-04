package io.gatling.jsonbenchmark.file;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.logic.BlackHole;

import java.io.File;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
public class JacksonASTBenchmark {


    private static final ObjectMapper JACKSON_MAPPER = new ObjectMapper();


    public static final String FILE_ACTION_LABEL = ( "data/actionLabel.json" );
    public static final String FILE_CITM_CATALOG = ( "data/citm_catalog.json" );
    public static final String FILE_MEDIUM = ( "data/medium.json" );
    public static final String FILE_MENU = ( "data/menu.json" );
    public static final String FILE_SGML = ( "data/sgml.json" );
    public static final String FILE_WEBXML = ( "data/webxml.json" );
    public static final String FILE_WIDGET = ( "data/widget.json" );


    private Object parse(String fileName) throws Exception {
            return JACKSON_MAPPER.readTree ( new File (fileName) );
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit ( TimeUnit.NANOSECONDS)
    public void actionLabel(BlackHole bh) throws Exception {
        bh.consume( parse( FILE_ACTION_LABEL ) );
    }


    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void citmCatalog(BlackHole bh) throws Exception {
        bh.consume( parse( FILE_CITM_CATALOG ) );
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void medium(BlackHole bh) throws Exception {
        bh.consume( parse( FILE_MEDIUM ) );
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void menu(BlackHole bh) throws Exception {
        bh.consume( parse( FILE_MENU ) );
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void sgml(BlackHole bh) throws Exception {
        bh.consume( parse( FILE_SGML ) );
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void webxml(BlackHole bh) throws Exception {
        bh.consume( parse( FILE_WEBXML ) );
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void widget(BlackHole bh) throws Exception {
        bh.consume( parse( FILE_WIDGET ) );
    }


}
