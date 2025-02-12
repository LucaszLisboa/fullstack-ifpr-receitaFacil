import axios from 'axios';

const BASE_URL = 'http://localhost:8080/medico';

export const getMedicos = () => {
  try {
    return axios.get(`${BASE_URL}`);
  } catch (error) {
    console.error(error);
  }
}

export const createMedico = (medico) => {
  try {
    return axios.post(`${BASE_URL}`, medico);
  } catch (error) {
    console.error(error);
  }
}

export const updateMedico = (medico) => {
  try {
    return axios.put(`${BASE_URL}/${medico.id}`, medico);
  } catch (error) {
    console.error(error);
  }
}

export const deleteMedico = (id) => {
  try {
    return axios.delete(`${BASE_URL}/${id}`);
  } catch (error) {
    console.error(error);
  }
}
