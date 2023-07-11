package management;

import readAndWriteFile.ReadAndWriteProducts;
import management.iManagement.Management;
import model.Product;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class ProductManagement implements Management<Product> {
    private List<Product> productList = null;
    private ReadAndWriteProducts readAndWriteProducts = new ReadAndWriteProducts();

    public ProductManagement() {
        try {
            this.productList = readAndWriteProducts.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Product product) {
        try {
            this.productList = readAndWriteProducts.readFile();

            this.productList.add(product);
            this.readAndWriteProducts.writeFile(this.productList);

            System.out.println("Thêm Sản Phẩm Thành Công !!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(String id, Product product) {
        try {
            this.productList = this.readAndWriteProducts.readFile();

            int index = findIndexById(id);
            if (index != -1) {
                this.productList.set(index, product);
                this.readAndWriteProducts.writeFile(this.productList);

                System.out.println("Sửa Sản Phẩm Thành Công !!!");
            } else {
                System.out.println("Không Tìm Được Sản Phẩm Với Mã Sản Phẩm Trên !!!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        try {
            this.productList = this.readAndWriteProducts.readFile();

            int index = findIndexById(id);
            if (index != -1) {
                this.productList.remove(index);
                this.readAndWriteProducts.writeFile(this.productList);

                System.out.println("Xóa Sản Phẩm Thành Công !!!");
            } else {
                System.out.println("Không Tìm Được Sản Phẩm Với Mã Sản Phẩm Trên !!!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int findIndexById(String id) {
        try {
            this.productList = this.readAndWriteProducts.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < this.productList.size(); i++) {
            if (id.equalsIgnoreCase(this.productList.get(i).getProductId())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<Product> getAll() {
        try {
            return this.productList = this.readAndWriteProducts.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> sortAscProduct() {
        try {
            this.productList = this.readAndWriteProducts.readFile();
            this.productList.sort(Comparator.comparingDouble(Product::getPrice));
            return this.productList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> sortDecProduct() {
        try {
            this.productList = this.readAndWriteProducts.readFile();
            this.productList.sort(Comparator.comparingDouble(Product::getPrice).reversed());
            return this.productList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
