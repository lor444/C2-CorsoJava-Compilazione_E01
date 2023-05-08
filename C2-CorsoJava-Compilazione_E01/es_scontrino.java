class Percentuale{

    public static final double MAX_VALUE=100.0;
    public static final double MIN_VALUE=-100.0;

    private double value;
    private boolean valid=false;

    public Percentuale(double value){
        setValue(value);
    }

    public double getValue(){
        return this.value;
    }

    public void setValue(double value){
        if(value>=Percentuale.MIN_VALUE && value<=Percentuale.MAX_VALUE){
            this.value = value;
            this.valid=true;
        }else{
            this.value=0;
            this.valid=false;
        }

    }

    public boolean isValid(){
        return this.valid;
    }

}

class Sconto{

    public static final double MAX_VALUE=100.0;
    public static final double MIN_VALUE=0;

    private Percentuale value;
    private boolean valid;

    public Sconto(Percentuale value){
        this.setValue(value);
    }

    public Percentuale getValue(){
        return this.value;
    }
    public void setValue(Percentuale value){
        if(value!=null && value.isValid() && value.getValue()>=MIN_VALUE) {
            this.value=value;
            this.valid=true;
        }else{
            this.value=null;
            this.valid=false;
        }
    }

    public boolean isValid(){
        return this.valid;
    }


    public double calcolaSconto(double importo){
        if(this.isValid()){
            return importo / 100.0 * this.value.getValue();
        }else{
            return 0;
        }
    }

}

class Iva{

    private double aliquota=22.0;

    public Iva(){
    }

    public double getAliquota(){
        return this.aliquota;
    }

    public double calcolaIva(double imponibile){
        return imponibile / 100.0 * this.aliquota;
    }

}


class Riga{

    private double prezzoUnitario;
    private Sconto sconto;
    private Iva iva;
    private double quantita;

    public double getPrezzoUnitario(){
        return this.prezzoUnitario;
    }
    
    public void setPrezzoUnitario(double prezzoUnitario){
        this.prezzoUnitario=prezzoUnitario;
    }

    public Sconto getSconto(){
        return this.sconto;
    }

    public void setSconto(Sconto sconto){
        this.sconto=sconto;
    }

    public Iva getIva(){
        return this.iva;
    }

    public void setIva(Iva iva){
        this.iva=iva;
    }

    public double getQuantita(){
        return this.quantita;
    }

    public void setQuantita(double quantita){
        this.quantita=quantita;
    }

    public double getPrezzoTotale(){
        double temp=0.0;
        temp = prezzoUnitario * quantita;
        if(this.sconto!=null && this.sconto.isValid()){
            double sc = this.sconto.calcolaSconto(temp);
            temp -= sc;
        }
        if(this.iva != null){
            double imposta = this.iva.calcolaIva(temp);
            temp += imposta;
        }
        return temp;
    }   

}