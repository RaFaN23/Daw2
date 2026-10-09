interface Usuario {
    nombre: string;
    apellido: string;
    edad: number;
}
function saludar(usuario: Usuario): string {
    return "Hola " + usuario.nombre + " " + usuario.apellido + ". Edad: " + usuario.edad;
}
const usuarios: Usuario = {
    nombre: "Rafa",
    apellido: "Villavicencio",
    edad: 21
};
function ejecutarSaludo(): void {
    let usuario = usuarios;
    alert(saludar(usuario));
}