
export function aplicarTema(): void {
  const temaLocal = localStorage.getItem('tema');
  const temaCookie = leerCookie('tema');
  const tema = temaLocal ?? temaCookie ?? 'claro';

  document.body.classList.toggle('oscuro', tema === 'oscuro');
}

export function leerCookie(nombre: string): string | null {
  const cookies = document.cookie.split('; ');

  for (const cookie of cookies) {
    const [clave, valor] = cookie.split('=');
    if (clave === nombre) {
      return decodeURIComponent(valor);
    }
  }

  return null;
}
