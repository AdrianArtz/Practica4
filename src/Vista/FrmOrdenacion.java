package Vista;

import Controlador.ControladorPersona;
import controlador.tda.lista.exception.PosicionException;
import javax.swing.JOptionPane;

public class FrmOrdenacion extends javax.swing.JFrame {

    private ControladorPersona CP = new ControladorPersona();
    private int aleatorios = 10000;
    private int x, y;

    public FrmOrdenacion() {
        initComponents();
        setLocationRelativeTo(this);
        x = 0;
        y = 0;

    }

    private String[] generarNombresAleatorios(int cantidad) {

        String[] nombresAleatorios = new String[cantidad];
        String[] nombres = {"Andrea", "Adrián", "Britney", "David", "Baldomero", "Balduino", "Baldwin", "Baltasar",
            "Barry", "Bartolo", "Hilary", "Karen", "Yerick", "Thais", "Yovin", "José", "Samael",
            "Bartolomé", "Barak", "Baruj", "Candelaria", "Bándida", "Canela", "Caridad", "Carina", "Carisa",
            "Caritina", "Carlota", "Baltazar"};
        String[] apellidos = {"Gomez", "Guerrero", "Cardenas", "Cardiel", "Cardona", "Cardoso", "Cariaga", "Carillo",
            "Carrión", "Castillo", "Castorena", "Castro", "Grande", "Grangenal", "Grano", "Grasia", "Griego", "Hernández",
            "Grigalva", "Ramirez", "Calva", "Gonzaga", "Sanchéz", "Cueva", "Peralta"};

        for (int i = 0; i < cantidad; i++) {
            nombresAleatorios[i] = nombres[(int) (Math.floor(Math.random() * ((nombres.length - 1) - 0 + 1) + 0))] + " "
                    + apellidos[(int) (Math.floor(Math.random() * ((apellidos.length - 1) - 0 + 1) + 0))];
        }

        return nombresAleatorios;
    }

    private Integer[] generarEdadAleatorios(int cantidad) {
        int max = 40;
        int min = 17;
        int range = max - min + 1;
        Integer[] edadesAleatorios = new Integer[cantidad];

        for (int i = 0; i < cantidad; i++) {
            edadesAleatorios[i] = (int) (Math.random() * range) + min;
        }

        return edadesAleatorios;

    }

    private String[] generarCedulasAleatorias(int cantidad) {
        int max = 99999999;
        int min = 11111111;
        int range = max - min + 1;
        String[] cedulasAleatorias = new String[cantidad];

        for (int i = 0; i < cantidad; i++) {
            cedulasAleatorias[i] = "11" + (int) (Math.random() * range);
        }
        return cedulasAleatorias;
    }

    private Character[] generarSexoAleatorio(int cantidad) {
        Character[] sexoAleatorio = new Character[cantidad];
        Character[] sexo = {'M', 'F'};
        for (int i = 0; i < cantidad; i++) {
            sexoAleatorio[i] = sexo[(int) (Math.floor(Math.random() * ((sexo.length - 1) - 0 + 1) + 0))];
        }
        return sexoAleatorio;
    }

    private Double[] generarGananciasAleatorias(int cantidad) {
        double max = 1000;
        double min = 500;
        double range = max - min + 1;
        Double[] gananciasAleatorios = new Double[cantidad];
        for (int i = 0; i < cantidad; i++) {
            double gananciaTemp = (Double) (Math.random() * range) + min;
            gananciasAleatorios[i] = Math.round(gananciaTemp * 100.0) / 100.0;
        }
        return gananciasAleatorios;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        e = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        c = new javax.swing.JTextField();
        sx = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        gg = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        crearBttn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        aleatoriosBttn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableListaPersonas = new javax.swing.JTable();
        atributoBox = new javax.swing.JComboBox<>();
        metodoBox = new javax.swing.JComboBox<>();
        tipoOrdenacionBox = new javax.swing.JComboBox<>();
        ordenarBttn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel1.setText("PERSONA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 280, 40));
        jPanel1.add(nc, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 460, 30));

        jLabel2.setText("Nombres Completos");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 250, 20));
        jPanel1.add(e, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 100, 30));

        jLabel3.setText("Edad");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 110, -1));

        jLabel4.setText("Cedula");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 110, -1));
        jPanel1.add(c, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 460, 30));
        jPanel1.add(sx, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 100, 30));

        jLabel5.setText("Sexo");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, 110, 10));
        jPanel1.add(gg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 460, 30));

        jLabel6.setText("Ganancias");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 110, -1));

        crearBttn.setText("CREAR");
        crearBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearBttnActionPerformed(evt);
            }
        });
        jPanel1.add(crearBttn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 160, -1));

        jLabel7.setText("ADRIÁN HERNÁNDEZ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, 20));

        aleatoriosBttn.setText("GENERAR ALEATORIOS");
        aleatoriosBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aleatoriosBttnActionPerformed(evt);
            }
        });
        jPanel1.add(aleatoriosBttn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 230, -1));

        tableListaPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombres Completos", "Edad", "Sexo", "Cedula", "Ganancias"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableListaPersonas);
        if (tableListaPersonas.getColumnModel().getColumnCount() > 0) {
            tableListaPersonas.getColumnModel().getColumn(0).setResizable(false);
            tableListaPersonas.getColumnModel().getColumn(0).setPreferredWidth(200);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 610, 320));

        atributoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ORDENAR POR", "nombreCompleto", "edad", "sexo", "cedula", "ganancias" }));
        jPanel1.add(atributoBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 680, 180, -1));

        metodoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ORDENAR POR", "METODO SHELL", "QUICK SORT" }));
        jPanel1.add(metodoBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 680, 180, -1));

        tipoOrdenacionBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TIPO DE ORDENACION", "ASCENDENTE", "DESCENDENTE" }));
        jPanel1.add(tipoOrdenacionBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 680, 210, -1));

        ordenarBttn.setText("ORDENAR");
        ordenarBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordenarBttnActionPerformed(evt);
            }
        });
        jPanel1.add(ordenarBttn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 730, 150, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crearBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearBttnActionPerformed
        try {
            guardar();
            limpiar();
        } catch (PosicionException ex) {
        }
        if (x >= 3) {
            crearBttn.setEnabled(false);
        }

    }//GEN-LAST:event_crearBttnActionPerformed

    private void aleatoriosBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aleatoriosBttnActionPerformed

        try {
            guardarAleatorios();

        } catch (PosicionException ex) {}
        if (y == 1) {
            aleatoriosBttn.setEnabled(false);
        }
    }//GEN-LAST:event_aleatoriosBttnActionPerformed

    private void ordenarBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordenarBttnActionPerformed
        try {
            ordenarPor();
        } catch (PosicionException ex) {} catch (Exception ex) {}
    }//GEN-LAST:event_ordenarBttnActionPerformed

    private void mostrarTabla() throws PosicionException {
        String lista[][] = CP.mostrarLista();
        tableListaPersonas.setModel(new javax.swing.table.DefaultTableModel(
                lista,
                new String[]{
                    "Nombre Completo", "Edad", "Sexo", "Cedula", "Ganancias"
                }
        ));
        if (tableListaPersonas.getColumnModel().getColumnCount() > 0) {
            tableListaPersonas.getColumnModel().getColumn(0).setResizable(false);
            tableListaPersonas.getColumnModel().getColumn(0).setPreferredWidth(200);
        }
    }
    


    private void ordenarPor() throws PosicionException, Exception {
        String ordenarPorAtributo = atributoBox.getSelectedItem().toString();
        String ordenarPorMetodo = metodoBox.getSelectedItem().toString();
        String tipoOrdenacion = tipoOrdenacionBox.getSelectedItem().toString();

        if (ordenarPorAtributo.equals("ORDENAR POR") || ordenarPorMetodo.equals("ORDENAR POR") || tipoOrdenacion.equals("TIPO DE ORDENACION")) {
            JOptionPane.showMessageDialog(this, "DEBE ELEGIR EL ATRIBUTO, EL METODO Y EL TIPO DE ORDENACIÓN");

        } else {
            CP.ordenar(ordenarPorAtributo, ordenarPorMetodo, tipoOrdenacion);
            mostrarTabla();
            reiniciarBox();
        }

    }

    private void guardar() throws PosicionException {
        if (nc.getText() == "" || nc.getText().isEmpty() || e.getText() == "" || e.getText().isEmpty()
                || sx.getText() == "" || sx.getText().isEmpty() || c.getText() == "" || c.getText().isEmpty() || gg.getText() == ""
                || gg.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Faltan Datos");
        } else {
            String nombreCompleto = nc.getText();
            Integer edad = Integer.valueOf(e.getText());
            Character sexo = sx.getText().charAt(0);
            String cedula = c.getText();
            Double ganancias = Double.valueOf(gg.getText());

            CP.crearPersona(nombreCompleto, edad, sexo, cedula, ganancias);
            x++;
            aleatorios = aleatorios - x;
            JOptionPane.showMessageDialog(this, "Creado con exito");
            mostrarTabla();
        }

    }

    private void guardarAleatorios() throws PosicionException {

        String[] nombresCompletos = generarNombresAleatorios(aleatorios);
        Integer[] edades = generarEdadAleatorios(aleatorios);
        String[] cedulas = generarCedulasAleatorias(aleatorios);
        Character[] sexos = generarSexoAleatorio(aleatorios);
        Double[] ganancias = generarGananciasAleatorias(aleatorios);
        for (int i = 0; i < aleatorios; i++) {
            CP.crearPersona(nombresCompletos[i], edades[i], sexos[i], cedulas[i], ganancias[i]);
        }
        mostrarTabla();
        y++;
        JOptionPane.showMessageDialog(this, "Creado con exito las " + aleatorios + " personas");
    }

    private void limpiar() {
        nc.setText("");
        e.setText("");
        sx.setText("");
        c.setText("");
        gg.setText("");
    }

    private void reiniciarBox() {
        atributoBox.setSelectedIndex(0);
        metodoBox.setSelectedIndex(0);
        tipoOrdenacionBox.setSelectedIndex(0);

    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmOrdenacion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmOrdenacion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmOrdenacion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmOrdenacion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmOrdenacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aleatoriosBttn;
    private javax.swing.JComboBox<String> atributoBox;
    private javax.swing.JTextField c;
    private javax.swing.JButton crearBttn;
    private javax.swing.JTextField e;
    private javax.swing.JTextField gg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> metodoBox;
    private javax.swing.JTextField nc;
    private javax.swing.JButton ordenarBttn;
    private javax.swing.JTextField sx;
    private javax.swing.JTable tableListaPersonas;
    private javax.swing.JComboBox<String> tipoOrdenacionBox;
    // End of variables declaration//GEN-END:variables
}
