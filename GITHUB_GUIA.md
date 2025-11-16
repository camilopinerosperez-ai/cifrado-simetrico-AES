# 🚀 GUÍA COMPLETA: SUBIR PROYECTO A GITHUB

## 📋 Contenido
1. [Pre-requisitos](#pre-requisitos)
2. [Método 1: Usando GitHub Web (Más Fácil)](#método-1-usando-github-web-más-fácil)
3. [Método 2: Usando Git en Terminal (Recomendado)](#método-2-usando-git-en-terminal-recomendado)
4. [Verificar que Funcionó](#verificar-que-funcionó)
5. [Solución de Problemas](#solución-de-problemas)

---

## Pre-requisitos

### ✅ Necesitas tener:

1. **Cuenta de GitHub** - Si no tienes, créala en https://github.com/signup
2. **Git instalado** (solo para Método 2)
   - Windows: Descarga de https://git-scm.com/download/win
   - Mac: Ya viene instalado, o usa `brew install git`
   - Linux: `sudo apt-get install git` (Ubuntu/Debian)

### 📁 Estructura de tu proyecto (lo que ya tienes):

```
CifradoSimetrico/
│
├── src/
│   └── CifradoTelefonica.java    # Código principal
│
├── README.md                      # Descripción del proyecto
├── DOCUMENTACION.md               # Documentación técnica
├── LICENSE                        # Licencia MIT
└── .gitignore                     # Archivos a ignorar
```

---

## Método 1: Usando GitHub Web (Más Fácil)

### ⏱️ Tiempo: 5-10 minutos

Este método es perfecto si no estás familiarizado con Git o la terminal.

### Paso 1: Crear Repositorio en GitHub

1. Ve a https://github.com
2. Inicia sesión con tu cuenta
3. Click en el botón **"+"** (arriba a la derecha) → **"New repository"**
4. Configura:
   - **Repository name:** `cifrado-simetrico-telefonica`
   - **Description:** `Sistema de cifrado simétrico AES-256 para protección de datos en telecomunicaciones`
   - **Visibilidad:** 
     - ✅ **Public** (recomendado para portafolio)
     - ⚪ Private (si prefieres mantenerlo privado)
   - **NO marques** "Add a README file" (ya lo tienes)
   - **NO marques** "Add .gitignore" (ya lo tienes)
   - **NO marques** "Choose a license" (ya lo tienes)
5. Click en **"Create repository"**

### Paso 2: Subir Archivos Manualmente

**Opción A: Drag & Drop (Arrastrar y Soltar)**

1. En la página del nuevo repositorio, verás un link que dice **"uploading an existing file"**
2. Click en ese link
3. **Arrastra** todos los archivos y carpetas desde tu computadora a la ventana del navegador:
   - Arrastra la carpeta `src` completa
   - Arrastra `README.md`
   - Arrastra `DOCUMENTACION.md`
   - Arrastra `LICENSE`
   - Arrastra `.gitignore`
4. En el campo "Commit changes":
   - Mensaje: `Initial commit - Sistema de cifrado simétrico AES-256`
5. Click en **"Commit changes"**

**Opción B: Subir Archivo por Archivo**

1. Click en **"Add file"** → **"Upload files"**
2. Click en **"choose your files"**
3. Selecciona todos los archivos (puedes seleccionar múltiples con Ctrl+Click)
4. Escribe mensaje de commit: `Initial commit - Sistema de cifrado simétrico AES-256`
5. Click en **"Commit changes"**

✅ **¡Listo!** Tu proyecto ya está en GitHub.

---

## Método 2: Usando Git en Terminal (Recomendado)

### ⏱️ Tiempo: 3-5 minutos

Este método es más profesional y te permite actualizar el proyecto fácilmente en el futuro.

### Paso 1: Crear Repositorio en GitHub

1. Ve a https://github.com
2. Click en **"+"** → **"New repository"**
3. Configura:
   - **Repository name:** `cifrado-simetrico-telefonica`
   - **Description:** `Sistema de cifrado simétrico AES-256 para protección de datos en telecomunicaciones`
   - **Visibilidad:** Public (recomendado)
   - **NO marques nada más** (ya tienes README, .gitignore, LICENSE)
4. Click en **"Create repository"**
5. **IMPORTANTE:** En la página siguiente, GitHub te mostrará comandos. Copia la URL que aparece (algo como `https://github.com/TU_USUARIO/cifrado-simetrico-telefonica.git`)

### Paso 2: Configurar Git (Solo Primera Vez)

Abre tu terminal (CMD, PowerShell, o Terminal) y ejecuta:

```bash
# Configura tu nombre (usa el de tu cuenta de GitHub)
git config --global user.name "Tu Nombre"

# Configura tu email (el de tu cuenta de GitHub)
git config --global user.email "tuemail@ejemplo.com"
```

### Paso 3: Subir el Proyecto

**Navega a la carpeta del proyecto:**

```bash
# Windows (ajusta la ruta según donde lo guardaste)
cd C:\Users\TuUsuario\Descargas\CifradoSimetrico

# Mac/Linux
cd ~/Descargas/CifradoSimetrico
```

**Inicializa Git y sube el proyecto:**

```bash
# 1. Inicializar repositorio Git
git init

# 2. Agregar todos los archivos al staging
git add .

# 3. Crear el primer commit
git commit -m "Initial commit - Sistema de cifrado simétrico AES-256"

# 4. Configurar la rama principal como 'main'
git branch -M main

# 5. Conectar con GitHub (REEMPLAZA con TU URL)
git remote add origin https://github.com/TU_USUARIO/cifrado-simetrico-telefonica.git

# 6. Subir los archivos a GitHub
git push -u origin main
```

**Si Git te pide autenticación:**

GitHub ya no acepta contraseñas desde 2021. Necesitas un **Personal Access Token**.

#### Cómo obtener un Token:

1. Ve a GitHub → Click en tu foto (arriba derecha) → **Settings**
2. Scroll hasta abajo → **Developer settings**
3. **Personal access tokens** → **Tokens (classic)**
4. **Generate new token** → **Generate new token (classic)**
5. Dale un nombre: "Git desde terminal"
6. Marca el checkbox: **repo** (esto da acceso a repositorios)
7. Click en **"Generate token"**
8. **COPIA EL TOKEN** (solo se muestra una vez)
9. Cuando Git pida contraseña, pega el token (no tu contraseña)

✅ **¡Listo!** Tu proyecto está en GitHub.

---

## Verificar que Funcionó

### ✅ Checklist de Verificación:

1. Ve a `https://github.com/TU_USUARIO/cifrado-simetrico-telefonica`
2. Deberías ver:
   - ✅ El README.md renderizado con toda la información bonita
   - ✅ La carpeta `src/` con el archivo Java
   - ✅ Los archivos LICENSE, DOCUMENTACION.md, .gitignore
   - ✅ Badges (escudos) de colores en el README
   - ✅ Estructura de carpetas navegable

### 📸 Captura de Pantalla para el Profesor

Toma captura que muestre:
- La URL del repositorio
- El README renderizado
- La estructura de archivos

---

## Actualizar el Proyecto (Futuras Modificaciones)

Si haces cambios y quieres actualizarlos en GitHub:

### Usando Git (Terminal):

```bash
# 1. Navega a la carpeta del proyecto
cd ruta/a/CifradoSimetrico

# 2. Agregar cambios
git add .

# 3. Crear commit con descripción del cambio
git commit -m "Descripción de lo que cambiaste"

# 4. Subir a GitHub
git push
```

### Usando GitHub Web:

1. Ve a tu repositorio en GitHub
2. Navega al archivo que quieres editar
3. Click en el ícono del lápiz (✏️) **"Edit this file"**
4. Haz los cambios
5. Scroll abajo → **"Commit changes"**

---

## Solución de Problemas

### ❌ Error: "Permission denied (publickey)"

**Problema:** Git no puede autenticarse con GitHub

**Solución:**
```bash
# Usa HTTPS en lugar de SSH
git remote set-url origin https://github.com/TU_USUARIO/cifrado-simetrico-telefonica.git
git push
```

### ❌ Error: "Updates were rejected"

**Problema:** El repositorio remoto tiene cambios que no tienes localmente

**Solución:**
```bash
git pull origin main --rebase
git push origin main
```

### ❌ Error: "Repository not found"

**Problema:** La URL del repositorio está mal

**Solución:**
```bash
# Verificar la URL actual
git remote -v

# Cambiarla si está mal (REEMPLAZA con tu URL correcta)
git remote set-url origin https://github.com/TU_USUARIO/cifrado-simetrico-telefonica.git
```

### ❌ No puedo ver el .gitignore en mi explorador

**Problema:** Los archivos que empiezan con punto están ocultos

**Solución:**
- **Windows:** En el explorador → Ver → Marcar "Elementos ocultos"
- **Mac:** En Finder → Cmd+Shift+. (punto)
- **Linux:** En el navegador de archivos → Ver → Mostrar archivos ocultos

---

## Personalizar el README

### Cambiar "TU_USUARIO" en el README:

1. Abre `README.md`
2. Busca: `https://github.com/TU_USUARIO/`
3. Reemplaza `TU_USUARIO` con tu nombre de usuario real de GitHub
4. Guarda el archivo
5. Sube los cambios (usando Git o editando en GitHub web)

---

## Hacer que tu Proyecto se Vea Profesional

### 1. Agregar un Screenshot

Toma captura de tu programa ejecutándose:

```bash
# Crea una carpeta para imágenes
mkdir screenshots
# Agrega tu captura ahí (por ejemplo: demo.png)
```

Luego en el README, agrega:
```markdown
## 📸 Demo

![Demostración](screenshots/demo.png)
```

### 2. Agregar Temas (Topics) en GitHub

1. Ve a tu repositorio
2. Click en el engranaje ⚙️ junto a "About"
3. Agrega topics: `java`, `cryptography`, `aes`, `encryption`, `security`, `telefonica`
4. Click **"Save changes"**

### 3. Hacer el Proyecto "Pinned" en tu Perfil

1. Ve a tu perfil de GitHub (click en tu foto)
2. En la sección "Pinned", click **"Customize your pins"**
3. Selecciona `cifrado-simetrico-telefonica`
4. Click **"Save pins"**

---

## Comandos Git Útiles (Cheat Sheet)

```bash
# Ver estado de archivos
git status

# Ver historial de commits
git log --oneline

# Ver cambios no guardados
git diff

# Deshacer cambios en un archivo (antes de commit)
git checkout -- nombre_archivo.java

# Ver repositorios remotos conectados
git remote -v

# Clonar tu propio repositorio en otra computadora
git clone https://github.com/TU_USUARIO/cifrado-simetrico-telefonica.git
```

---

## URLs Importantes

- **Tu repositorio:** `https://github.com/TU_USUARIO/cifrado-simetrico-telefonica`
- **GitHub Docs:** https://docs.github.com
- **Git Cheat Sheet:** https://education.github.com/git-cheat-sheet-education.pdf

---

## 🎓 Para Entregar al Profesor

Comparte el enlace de tu repositorio:

```
https://github.com/TU_USUARIO/cifrado-simetrico-telefonica
```

El profesor podrá:
- Ver todo tu código
- Leer la documentación
- Clonar el repositorio
- Ver tu historial de commits
- Evaluar tu organización y profesionalismo

---

## ✅ Checklist Final

Antes de compartir tu repositorio, verifica:

- [ ] El README se ve bien en GitHub (con badges, títulos, ejemplos)
- [ ] La carpeta `src/` contiene el código Java
- [ ] El código tiene comentarios en español
- [ ] El archivo LICENSE está presente
- [ ] El .gitignore funciona (no hay archivos .class en GitHub)
- [ ] La documentación técnica está completa
- [ ] Cambiaste "TU_USUARIO" por tu usuario real en URLs
- [ ] Agregaste topics al repositorio
- [ ] Tomaste captura para el foro

---

¡Felicidades! Ahora tienes un proyecto profesional en GitHub que puedes mostrar en tu portafolio. 🎉

**Pro Tip:** Incluye el enlace de este proyecto en tu CV y LinkedIn - demuestra tus habilidades en:
- ✅ Java
- ✅ Criptografía
- ✅ Seguridad Informática
- ✅ Git/GitHub
- ✅ Documentación técnica
