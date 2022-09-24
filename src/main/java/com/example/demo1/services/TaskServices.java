package com.example.demo1.services;

import com.example.demo1.entities.Task1;
import com.example.demo1.repositories.TaskRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServices {
        private TaskRepositorio repository;
        public TaskServices(TaskRepositorio repository) {
                this.repository = repository;

        }
/*    Task1 t1;
    Task1 t2;
    Task1 t3;
    Task1 t4;
    Task1 t5;

    TaskList1 metas;

    public TaskServices(){
        this.t1 = new Task1("Recordar POO",true, LocalDate.of(2022,8,23));
        this.t2 = new Task1("Conocer Intellij IDEA Ultimate",false, LocalDate.of(2022,8,24));
        this.t3 = new Task1("Conocer Java Spring Boot",false, LocalDate.of(2022,8,25));
        this.t4 = new Task1("Afinar la arquitectura del proyecto",false, LocalDate.of(2022,8,26));
        this.t5 = new Task1("Finalizar tareas",false, LocalDate.of(2022,9,15));

        this.metas = new TaskList1("Tareas iniciales");
        metas.addTaskList(t1);
        metas.addTaskList(t2);
        metas.addTaskList(t3);
        metas.addTaskList(t4);
        metas.addTaskList(t5);

        }


        public TaskList1 getTaskList1(){
        return this.metas;*/
        /*
        public Task1 createRepository()
        */
        public List<Task1> getTaskList() {
                return this.repository.findAll();
        }
        public Task1 createTask(Task1 newTask){
                return this.repository.save(newTask);
        }
        public Boolean taskFinished(Long id){//Declarar el metodo para marcar la tarea como finalizada
                Optional<Task1> task = this.repository.findById(id);//Importar la clase Optional e Identificar la tarea en el sistema devolviendo un dato de  tipo optional
                if(task.isPresent()){//Validar si la tarea exist
                        task.get().setDone(true);//Obtener la insatancia o el valor de un Optional y cambiar el estado del done
                        this.repository.save(task.get());//Almacena el nuevo estado del done
                        return true;//Garantiza que evidentemente se termino la tarea
                }
                return false;//Si la tarea no existe se retorna false para mantener la terea como "Tarea sin Terminar"
        }
        public Boolean deleteTask(Long id){//metodo para elminar una tarea por id
                this.repository.deleteById(id);//repositorio para eliminar la tarea
                return true;//Validar si se ejecuta la eliminación de la tarea
        }

}
