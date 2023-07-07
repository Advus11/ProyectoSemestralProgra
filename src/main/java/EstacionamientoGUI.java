import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EstacionamientoGUI {
        private List<Vehiculo> vehiculos;
        private Map<String, Cliente> clientes;
        private List<Double> ganancias;

        public EstacionamientoGUI() {
            vehiculos = new ArrayList<>();
            clientes = new HashMap<>();
            ganancias = new ArrayList<>();

            JFrame frame = new JFrame();
            frame.setTitle("Gestión de Estacionamiento");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLayout(new FlowLayout());

            JButton agregarBtn = new JButton("Agregar Vehículo");
            agregarBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    agregarVehiculo();
                }
            });

            JButton asociarBtn = new JButton("Asociar Vehículo a Cliente");
            asociarBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    asociarVehiculoACliente();
                }
            });

            JButton eliminarBtn = new JButton("Eliminar Vehículo");
            eliminarBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    eliminarVehiculo();
                }
            });

            JButton verBtn = new JButton("Ver Vehículos Registrados");
            verBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    verVehiculosRegistrados();
                }
            });

            JButton gananciasBtn = new JButton("Mostrar Ganancias");
            gananciasBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mostrarGanancias();
                }
            });

            frame.add(agregarBtn);
            frame.add(asociarBtn);
            frame.add(eliminarBtn);
            frame.add(verBtn);
            frame.add(gananciasBtn);

            frame.setVisible(true);
        }

    public void agregarVehiculo() {
        JFrame ventana = new JFrame("Agregar Vehículo");
        ventana.setSize(300, 250);
        ventana.setLayout(new GridLayout(7, 2));

        JLabel patenteLabel = new JLabel("Patente:");
        JTextField patenteField = new JTextField();

        JLabel colorLabel = new JLabel("Color:");
        JTextField colorField = new JTextField();

        JLabel marcaLabel = new JLabel("Marca:");
        JTextField marcaField = new JTextField();

        JLabel posicionLabel = new JLabel("Posición de Estacionamiento:");
        JTextField posicionField = new JTextField();

        JLabel horaLabel = new JLabel("Hora de Llegada (HH:MM):");
        JTextField horaField = new JTextField();

        JLabel minutoLabel = new JLabel("Minuto de Llegada:");
        JTextField minutoField = new JTextField();

        JButton agregarBtn = new JButton("Agregar");
        agregarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String patente = patenteField.getText();
                String color = colorField.getText();
                String marca = marcaField.getText();
                String posicion = posicionField.getText();
                String horaLlegada = horaField.getText();
                int minutoLlegada = Integer.parseInt(minutoField.getText());

                // Validar patente
                if (validarPatente(patente)) {
                    Vehiculo vehiculo = new Vehiculo(patente, color, marca, posicion, horaLlegada, minutoLlegada);
                    vehiculos.add(vehiculo);
                    ventana.dispose();
                    JOptionPane.showMessageDialog(null, "Vehículo agregado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "La patente ingresada ya existe.");
                }
            }
        });

        ventana.add(patenteLabel);
        ventana.add(patenteField);
        ventana.add(colorLabel);
        ventana.add(colorField);
        ventana.add(marcaLabel);
        ventana.add(marcaField);
        ventana.add(posicionLabel);
        ventana.add(posicionField);
        ventana.add(horaLabel);
        ventana.add(horaField);
        ventana.add(minutoLabel);
        ventana.add(minutoField);
        ventana.add(agregarBtn);

        ventana.setVisible(true);
    }

    public boolean validarPatente(String patente) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPatente().equals(patente)) {
                return false;
            }
        }
        return true;
    }

    public void asociarVehiculoACliente() {
        JFrame ventana = new JFrame("Asociar Vehículo a Cliente");
        ventana.setSize(300, 250);
        ventana.setLayout(new GridLayout(5, 2));

        JLabel nombreLabel = new JLabel("Nombre:");
        JTextField nombreField = new JTextField();

        JLabel apellidoLabel = new JLabel("Apellido:");
        JTextField apellidoField = new JTextField();

        JLabel contactoLabel = new JLabel("Número de Contacto:");
        JTextField contactoField = new JTextField();

        JLabel patenteLabel = new JLabel("Patente:");
        JTextField patenteField = new JTextField();

        JButton asociarBtn = new JButton("Asociar");
        asociarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String apellido = apellidoField.getText();
                String contacto = contactoField.getText();
                String patente = patenteField.getText();

                if (validarPatente(patente)) {
                    JOptionPane.showMessageDialog(null, "Ingrese una patente ya registrada.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    Cliente cliente = new Cliente(nombre, apellido, contacto, patente);
                    clientes.put(patente, cliente);
                    ventana.dispose();
                    JOptionPane.showMessageDialog(null, "Vehículo asociado correctamente al cliente.");
                }
            }
        });

        ventana.add(nombreLabel);
        ventana.add(nombreField);
        ventana.add(apellidoLabel);
        ventana.add(apellidoField);
        ventana.add(contactoLabel);
        ventana.add(contactoField);
        ventana.add(patenteLabel);
        ventana.add(patenteField);
        ventana.add(asociarBtn);

        ventana.setVisible(true);
    }

    public void eliminarVehiculo() {
        JFrame ventana = new JFrame("Eliminar Vehículo");
        ventana.setSize(300, 250);
        ventana.setLayout(new GridLayout(4, 2));

        JLabel patenteLabel = new JLabel("Patente:");
        JTextField patenteField = new JTextField();

        JLabel horaSalidaLabel = new JLabel("Hora de Salida (HH:MM):");
        JTextField horaSalidaField = new JTextField();

        JLabel minutoSalidaLabel = new JLabel("Minuto de Salida:");
        JTextField minutoSalidaField = new JTextField();

        JButton eliminarBtn = new JButton("Eliminar");
        eliminarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String patente = patenteField.getText();
                String horaSalida = horaSalidaField.getText();
                int minutoSalida = Integer.parseInt(minutoSalidaField.getText());

                if (validarPatente(patente)) {
                    JOptionPane.showMessageDialog(null, "Ingrese una patente ya registrada.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    double precio = calcularPrecio(patente, horaSalida, minutoSalida);
                    eliminarVehiculoDeLista(patente);
                    ganancias.add(precio); // Registrar la ganancia
                    ventana.dispose();
                    JOptionPane.showMessageDialog(null, "Vehículo eliminado correctamente.\nPrecio: $" + precio);
                }
            }
        });

        ventana.add(patenteLabel);
        ventana.add(patenteField);
        ventana.add(horaSalidaLabel);
        ventana.add(horaSalidaField);
        ventana.add(minutoSalidaLabel);
        ventana.add(minutoSalidaField);
        ventana.add(eliminarBtn);

        ventana.setVisible(true);
    }

    public double calcularPrecio(String patente, String horaSalida, int minutoSalida) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPatente().equals(patente)) {

                double costoTotalEstacionamiendo = calcularTiempoEstacionado(vehiculo.getHoraLlegada(), vehiculo.getMinutoLlegada(), horaSalida, minutoSalida);

                return costoTotalEstacionamiendo;
            }
        }
        return 0.0;
    }

    public double calcularTiempoEstacionado(String horaLlegada, int minutoLlegada, String horaSalida, int minutoSalida) {
        int horasLlegada = Integer.parseInt(horaLlegada);
        int minutosLlegada = minutoLlegada;
        int horasSalida = Integer.parseInt(horaSalida);
        int minutosSalida = minutoSalida;

        int minutosTotalesLlegada = horasLlegada * 60 + minutosLlegada;
        int minutosTotalesSalida = horasSalida * 60 + minutosSalida;

        int minutosTranscurridos = minutosTotalesSalida - minutosTotalesLlegada;

        double costoPorMinuto = 15.0;
        double costoTotal = costoPorMinuto * minutosTranscurridos;

        return costoTotal;
    }

    public void eliminarVehiculoDeLista(String patente) {
        Iterator<Vehiculo> iterator = vehiculos.iterator();
        while (iterator.hasNext()) {
            Vehiculo vehiculo = iterator.next();
            if (vehiculo.getPatente().equals(patente)) {
                iterator.remove();
                break;
            }
        }
    }

    public void verVehiculosRegistrados() {
        StringBuilder vehiculosRegistrados = new StringBuilder();
        for (Vehiculo vehiculo : vehiculos) {
            String patente = vehiculo.getPatente();
            if (clientes.containsKey(patente)) {
                Cliente cliente = clientes.get(patente);
                String nombre = cliente.getNombre();
                String apellido = cliente.getApellido();
                String horaLlegada = vehiculo.getHoraLlegada();
                int minutoLlegada = vehiculo.getMinutoLlegada();

                vehiculosRegistrados.append("Patente: ").append(patente)
                        .append(", Nombre: ").append(nombre)
                        .append(", Apellido: ").append(apellido)
                        .append(", Hora Llegada: ").append(horaLlegada)
                        .append(", Minuto Llegada: ").append(minutoLlegada)
                        .append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, vehiculosRegistrados.toString(), "Vehículos Registrados", JOptionPane.INFORMATION_MESSAGE);
    }
    public void mostrarGanancias() {
        double totalGanancias = 0.0;
        for (Double ganancia : ganancias) {
            totalGanancias += ganancia;
        }
        JOptionPane.showMessageDialog(null, "Ganancias del estacionamiento: $" + totalGanancias, "Ganancias", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EstacionamientoGUI();
            }
        });
    }
}


