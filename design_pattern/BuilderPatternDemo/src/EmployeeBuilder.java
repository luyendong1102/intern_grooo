public class EmployeeBuilder {

    private String name;

    public PosistionBuilder setName(String name) {
        this.name = name;
        return new PosistionBuilder(name);
    }

    public static class PosistionBuilder extends EmployeeBuilder {

        private String name;
        private String type;

        public PosistionBuilder(String name) {
            this.name = name;
        }



        public PosistionBuilder isDeveloper() {
            this.type = "Developer";
            return this;
        }

        public PosistionBuilder isHR() {
            this.type = "HR";
            return this;
        }

        public Employee build() {
            if(this.name == null) {
                return null;
            }
            if (this.type.equals("Developer")) {
                return new Developer(this.name);
            }
            if (this.type.equals("HR")) {
                return new Developer(this.name);
            }
            return null;
        }

    }

}
