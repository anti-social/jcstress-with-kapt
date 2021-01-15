package example;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.I_Result;

import static org.openjdk.jcstress.annotations.Expect.ACCEPTABLE;
import static org.openjdk.jcstress.annotations.Expect.FORBIDDEN;

@JCStressTest
@Outcome(id = "1", expect = FORBIDDEN, desc = "One increment was lost")
@Outcome(id = "2", expect = ACCEPTABLE, desc = "Both increments")
@State
public class StressTest {
    private final AtomicInt counter = new AtomicInt();

    @Actor
    public void inc1() {
        counter.inc();
    }

    @Actor
    public void inc2() {
        counter.inc();
    }

    @Arbiter void get(I_Result r) {
        r.r1 = counter.get();
    }
}
