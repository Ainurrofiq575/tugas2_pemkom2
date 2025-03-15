package generic;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class KoleksiFile extends AbstractTableModel {

    List<Inventaris> list = new ArrayList<>();
    private final String [] columnNames = {" Nama Barang", "Jumlah", "keterangan"
    };

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    synchronized public Object getValueAt(int rowIndex, int columnIndex) {
        Inventaris doc = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return doc.getFileName();
            case 1:
                return doc.getJumlah();
            case 2:
                return doc.getKeterangan();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column){
    return columnNames [column];
    }
    
public void add(Inventaris m) {
        // Input nama file baru
        String newName = JOptionPane.showInputDialog("Nama Barang:", m.getFileName());
        if (newName == null || newName.trim().isEmpty()) {
            return; // Jika nama tidak diisi, batal menambahkan
        }
        m.setFileName(newName);
        
        // Input jumlah barang
        String jumlahStr = JOptionPane.showInputDialog("Masukkan jumlah barang:");
        int jumlah;
        try {
            jumlah = Integer.parseInt(jumlahStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Jumlah harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        m.setJumlah(jumlah);

        // Input keterangan
        String[] options = {"Baik", "Rusak"};
        String keterangan = (String) JOptionPane.showInputDialog(null, "Pilih keterangan:",
                "Keterangan", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        m.setKeterangan(keterangan);
        
        // Tambahkan ke daftar
        list.add(m);
        fireTableRowsInserted(getRowCount(), getColumnCount());
    }

    public void set(int i, Inventaris m) {
        list.set(i, m);
        fireTableDataChanged();
    }

    public void clear() {
        list.clear();
        fireTableDataChanged();
    }
    
    public void removeRow(int rowIndex){
        if (rowIndex >= 0 && rowIndex < list.size()){
            list.remove(rowIndex);
            fireTableRowsDeleted(rowIndex, rowIndex);
        }
    }

    public void remove(int row) {
        list.remove(row);
        fireTableRowsDeleted(row, row);
    }

    public Inventaris get(int row) {
        return (Inventaris) list.get(row);
    }
    
//    public void setJumlah(int index, int jumlah) {
//    if (index >= 0 && index < list.size()) {
//        list.get(index).setJumlah(jumlah); // Memperbarui jumlah barang di objek Inventaris
//        fireTableCellUpdated(index, 2); // Memperbarui hanya kolom jumlah barang di tabel
//    }
//}


}
