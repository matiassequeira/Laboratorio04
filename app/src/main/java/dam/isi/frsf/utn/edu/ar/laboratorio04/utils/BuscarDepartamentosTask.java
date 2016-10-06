package dam.isi.frsf.utn.edu.ar.laboratorio04.utils;

import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import dam.isi.frsf.utn.edu.ar.laboratorio04.modelo.Ciudad;
import dam.isi.frsf.utn.edu.ar.laboratorio04.modelo.Departamento;
import dam.isi.frsf.utn.edu.ar.laboratorio04.utils.BusquedaFinalizadaListener;
import dam.isi.frsf.utn.edu.ar.laboratorio04.utils.FormBusqueda;

/**
 * Created by martdominguez on 22/09/2016.
 */
public class BuscarDepartamentosTask extends AsyncTask<FormBusqueda,Integer,List<Departamento>> {

    private BusquedaFinalizadaListener<Departamento> listener;

    public BuscarDepartamentosTask(BusquedaFinalizadaListener<Departamento> dListener){
        this.listener = dListener;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(List<Departamento> departamentos) {
        listener.busquedaFinalizada(departamentos);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        listener.busquedaActualizada("departamento "+values[0]+" de "+values[1]);

    }

    @Override
    protected List<Departamento> doInBackground(FormBusqueda... busqueda) {
        List<Departamento> todos = Departamento.getAlojamientosDisponibles();
        List<Departamento> resultado = new ArrayList<Departamento>();
        int contador = 0;

        Ciudad ciudadBuscada =  busqueda[0].getCiudad();

        Boolean permiteFumar=busqueda[0].getPermiteFumar();

        Integer cantHuespedes=busqueda[0].getHuespedes();

        Double precioMin=busqueda[0].getPrecioMinimo();

        Double precioMax=busqueda[0].getPrecioMaximo();

        for (Departamento depto: todos) {
            if (ciudadBuscada!=null && depto.getCiudad().equals(ciudadBuscada)){
                if(permiteFumar!=null && depto.getNoFumador().equals(permiteFumar) ) {
                    if (cantHuespedes != null && depto.getCapacidadMaxima()>=cantHuespedes) {
                        if (precioMin !=null && depto.getPrecio()>=precioMin){
                            if (precioMax!=null && depto.getPrecio()<=precioMax){
                                resultado.add(depto);
                            }
                            else if (precioMax==null){
                                resultado.add(depto);
                            }
                        }
                        else if (precioMin==null){
                            if (precioMax!=null && depto.getPrecio()<=precioMax){
                                resultado.add(depto);
                            }
                            else if (precioMax==null){
                                resultado.add(depto);
                            }
                        }

                    }
                    else if (cantHuespedes==null){
                        if (precioMin !=null && depto.getPrecio()>=precioMin){
                            if (precioMax!=null && depto.getPrecio()<=precioMax){
                                resultado.add(depto);
                            }
                            else if (precioMax==null){
                                resultado.add(depto);
                            }
                        }
                        else if (precioMin==null){
                            if (precioMax!=null && depto.getPrecio()<=precioMax){
                                resultado.add(depto);
                            }
                            else if (precioMax==null){
                                resultado.add(depto);
                            }
                        }
                    }


                }
                else if (permiteFumar ==null){
                    if (cantHuespedes != null && depto.getCapacidadMaxima()>=cantHuespedes) {
                        if (precioMin !=null && depto.getPrecio()>=precioMin){
                            if (precioMax!=null && depto.getPrecio()<=precioMax){
                                resultado.add(depto);
                            }
                            else if (precioMax==null){
                                resultado.add(depto);
                            }
                        }
                        else if (precioMin==null){
                            if (precioMax!=null && depto.getPrecio()<=precioMax){
                                resultado.add(depto);
                            }
                            else if (precioMax==null){
                                resultado.add(depto);
                            }
                        }
                    }
                    else if (cantHuespedes==null){
                        if (precioMin !=null && depto.getPrecio()>=precioMin){
                            if (precioMax!=null && depto.getPrecio()<=precioMax){
                                resultado.add(depto);
                            }
                            else if (precioMax==null){
                                resultado.add(depto);
                            }
                        }
                        else if (precioMin==null){
                            if (precioMax!=null && depto.getPrecio()<=precioMax){
                                resultado.add(depto);
                            }
                            else if (precioMax==null){
                                resultado.add(depto);
                            }
                        }
                    }
                }
            }
            else if (ciudadBuscada==null){
                if(permiteFumar!=null && depto.getNoFumador().equals(permiteFumar) ) {
                    if (cantHuespedes != null && depto.getCapacidadMaxima()>=cantHuespedes) {
                        if (precioMin !=null && depto.getPrecio()>=precioMin){
                            if (precioMax!=null && depto.getPrecio()<=precioMax){
                                resultado.add(depto);
                            }
                            else if (precioMax==null){
                                resultado.add(depto);
                            }
                        }
                        else if (precioMin==null){
                            if (precioMax!=null && depto.getPrecio()<=precioMax){
                                resultado.add(depto);
                            }
                            else if (precioMax==null){
                                resultado.add(depto);
                            }
                        }

                    }
                    else if (cantHuespedes==null){
                        if (precioMin !=null && depto.getPrecio()>=precioMin){
                            if (precioMax!=null && depto.getPrecio()<=precioMax){
                                resultado.add(depto);
                            }
                            else if (precioMax==null){
                                resultado.add(depto);
                            }
                        }
                        else if (precioMin==null){
                            if (precioMax!=null && depto.getPrecio()<=precioMax){
                                resultado.add(depto);
                            }
                            else if (precioMax==null){
                                resultado.add(depto);
                            }
                        }
                    }


                }
                else if (permiteFumar ==null){
                    if (cantHuespedes != null && depto.getCapacidadMaxima()>=cantHuespedes) {
                        if (precioMin !=null && depto.getPrecio()>=precioMin){
                            if (precioMax!=null && depto.getPrecio()<=precioMax){
                                resultado.add(depto);
                            }
                            else if (precioMax==null){
                                resultado.add(depto);
                            }
                        }
                        else if (precioMin==null){
                            if (precioMax!=null && depto.getPrecio()<=precioMax){
                                resultado.add(depto);
                            }
                            else if (precioMax==null){
                                resultado.add(depto);
                            }
                        }
                    }
                    else if (cantHuespedes==null){
                        if (precioMin !=null && depto.getPrecio()>=precioMin){
                            if (precioMax!=null && depto.getPrecio()<=precioMax){
                                resultado.add(depto);
                            }
                            else if (precioMax==null){
                                resultado.add(depto);
                            }
                        }
                        else if (precioMin==null){
                            if (precioMax!=null && depto.getPrecio()<=precioMax){
                                resultado.add(depto);
                            }
                            else if (precioMax==null){
                                resultado.add(depto);
                            }
                        }
                    }
                }
            }
            contador++;

            publishProgress(contador, todos.size());
        }
        Log.d("BuscarDepartamentosTask","ciudades buscadas"+contador);
        // TODO implementar: buscar todos los departamentos del sistema e ir chequeando las condiciones 1 a 1.
        // si cumplen las condiciones agregarlo a los resultados.
        return resultado;
    }
}
