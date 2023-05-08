class Test{
    
    public static double runTest(){
        Riga r=new Riga();
        r.setPrezzoUnitario(15.0);
        r.setQuantita(5);
        Sconto s =new Sconto(new Percentuale(7));
        r.setSconto(s);
        Iva i =new Iva();
        r.setIva(i);
        double tot=r.getPrezzoTotale();
        return tot;
    }
}