
package builder;

public class Bicicleta {

    private String modelo;
    private Quadro quadro;
    private Selim selim;
    private Roda rodaFrontal;
    private Roda rodaTraseira;

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setQuadro(Quadro quadro) {
        this.quadro = quadro;
    }

    public void setSelim(Selim selim) {
        this.selim = selim;
    }

    public void setRodaFrontal(Roda rodaFrontal) {
        this.rodaFrontal = rodaFrontal;
    }

//    Bicicleta(String abc, Quadro quadro, Selim selim, Roda rodaFrontal, Roda rodaTraseira) {
//        this.modelo = modelo;
    public void setRodaTraseira(Roda rodaTraseira) {
        this.rodaTraseira = rodaTraseira;
    }

//        this.quadro = quadro;
//        this.selim = selim;
//        this.rodaFrontal = rodaFrontal;
//        this.rodaTraseira = rodaTraseira;
//    }
    private Bicicleta(Builder builder) {
        this.modelo = builder.modelo;
        this.quadro = builder.quadro;
        this.selim = builder.selim;
        this.rodaFrontal = builder.rodaFrontal;
        this.rodaTraseira = builder.rodaTraseira;
    }

    public String getModelo() {
        return modelo;
    }

    public Quadro getQuadro() {
        return quadro;
    }

    public Selim getSelim() {
        return selim;
    }

    public Roda getRodaTraseira() {
        return rodaTraseira;
    }

    public Roda getRodaFrontal() {
        return rodaFrontal;
    }

    public static class Builder {

        private String modelo;
        private Quadro quadro;
        private Selim selim;
        private Roda rodaFrontal;
        private Roda rodaTraseira;

        public Builder modelo(String modelo) {
            this.modelo = modelo;
            return this;
        }

        public Builder quadro(Quadro quadro) {
            this.quadro = quadro;
            return this;
        }

        public Builder selim(Selim selim) {
            this.selim = selim;
            return this;
        }

        public Builder rodaFrontal(Roda rodaFrontal) {
            this.rodaFrontal = rodaFrontal;
            return this;
        }

        public Builder rodaTraseira(Roda rodaTraseira) {
            this.rodaTraseira = rodaTraseira;
            return this;
        }

        public Bicicleta build() {
            return new Bicicleta(this);
        }

    }
}
