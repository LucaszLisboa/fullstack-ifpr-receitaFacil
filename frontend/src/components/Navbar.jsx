import {Navbar, NavbarBrand, NavbarContent, NavbarItem, Link, Button} from "@heroui/react";
import { NavLink } from "react-router-dom";

export default function NavbarApp() {
  return (
    <Navbar className="bg-gradient-to-r from-blue-700 to-blue-300 text-white">
      <NavbarBrand>
        <p className="font-bold text-inherit">RECEITA IFPR</p>
      </NavbarBrand>
      <NavbarContent className="hidden sm:flex gap-6" justify="center">
        <NavbarItem>
          <NavLink className="text-white" to="/medicos">
            Médicos
          </NavLink>
        </NavbarItem>
        <NavbarItem>
          <NavLink className="text-white" to="/pacientes">
            Pacientes
          </NavLink>
        </NavbarItem>
        <NavbarItem>
          <NavLink className="text-white" to="/receitas">
            Receitas
          </NavLink>
        </NavbarItem>
      </NavbarContent>
      <NavbarContent justify="end">
      </NavbarContent>
    </Navbar>
  );
}