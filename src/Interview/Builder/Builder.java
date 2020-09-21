package Interview.Builder;


public class Builder {
    private String a;

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String getC() {
        return c;
    }

    private String b;
    private String c;

    private Builder(BuilderHelper helper) {
        this.a = helper.a;
        this.b = helper.b;
        this.c = helper.c;
    }

    public static class BuilderHelper {
        private String a;
        private String b;
        private String c;
        private Builder builder;

        BuilderHelper(String a, String c) {
            this.a = a;
            this.c = c;
        }

        BuilderHelper addC(String c) {
            this.c = c;
            return this;
        }

        Builder build() {
            builder = new Builder(this);
            return builder;
        }
    }
}
