export class Product {
    id?: number; // para especificar que no es obligatorio
    name: string;
    price: number;

    constructor(name: string, price: number) {
        this.name = name;
        this.price = price;
    }
}
