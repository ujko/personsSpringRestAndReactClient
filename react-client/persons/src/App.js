import React, { Component, useRef } from 'react';
import './App.css';
import Persons from './Persons/Persons';
import axios from 'axios';
import PersonDet from './Persons/PersonDet/PersonDet';
import { Toast } from 'primereact/toast';

class App extends Component {
  // toast = null;
  state = {
    persons: [],
    showDetails: false,
    personDetails: null
  }

  componentDidMount() {
    this.getAll();
  }

  getAll = () => {
    axios.get('http://localhost:8080/all').then(response => {
      const persons = response.data;
      this.setState({persons: persons});
    });
  }

  showDetailsHandler = (personId) => {
    axios.get('http://localhost:8080/person?id=' + personId).then(response => {
      const person = response.data;
      this.setState({personDetails: person});
    });
  }

  deleteHandler = (personId) => {
    axios.delete('http://localhost:8080/person/del/' + personId).then(response => {
      const deletedPerson = response.data;
      // this.toast = useRef(null);
      // this.toast.current.show({severity:'success', summary:'Person deleted', detail: 'Person deleted', life:3000});
      this.getAll();
      this.setState({personDetails: null});
    })
  }


  
  render() {
    let pers = null;
    if(this.state.personDetails !== null) {
      pers = <PersonDet person={this.state.personDetails}  deleteHandler={() => this.deleteHandler(this.state.personDetails.id)}/>
    }
    return (
      <div className="App">
        {/* <Toast ref={this.toast}></Toast> */}
        {pers}
       <Persons persons={this.state.persons} showDetailsHandler={this.showDetailsHandler}/>
      </div>
    );
  }
}

export default App;
