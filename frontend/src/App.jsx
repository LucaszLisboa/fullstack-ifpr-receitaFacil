
import { BrowserRouter } from 'react-router-dom'
import NavbarApp from './components/Navbar'
import { Rotas } from './routes/routes'

function App() {
  return (
    <BrowserRouter>
      <NavbarApp />
      <Rotas /> 
    </BrowserRouter>
  )
}

export default App
