import http from 'k6/http';
import { check, sleep } from 'k6';

// Definindo a configuração do teste
export const options = {
    vus: 10, // Número de usuários virtuais
    duration: '30s', // Duração do teste
};

export default function () {
    // Realizando a requisição GET para a API do Pokémon
    const res = http.get('https://pokeapi.co/api/v2/pokemon/pikachu');

    // Verificando se a resposta está correta
    check(res, {
        'is status 200': (r) => r.status === 200,
        'response time is less than 200ms': (r) => r.timings.duration < 200,
    });

    sleep(1); // Pausa entre as requisições
}
