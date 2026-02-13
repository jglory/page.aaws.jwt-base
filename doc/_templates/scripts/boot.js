
class Doc {
    constructor(tp, env, code) {
        this.tp = tp;
        this.env = env;
        this.serviceCode = this.env.data['SERVICE_CODE'];
        this.code = code;

        const tokens = tp.file.path(true).split("/");
        if (["A 소프트웨어 처리 흐름도", "E 시스템 처리 흐름도"].indexOf(tokens[2])>=0) {
            this.applicationType = tokens[3];
            this.jobType = "";
            for (let i=4; i<tokens.length-2; ++i) {
                this.jobType += tokens[i] + "/";
            }
            this.jobType += tokens[tokens.length-2];
        }

        return (async () => {
            if (this.no === undefined) {
                this.no = this.env.data['DOCUMENT_NO']
                this.id = this.env.data['SERVICE_CODE']+ '-' + this.code + '-' + String(this.no).padStart(6, '0');
                ++this.env.data['DOCUMENT_NO'];
                this.env.save();
            }
            return this;
        })();
    }
}

class Env {
    constructor(tp) {
        this.tp = tp;
        this.fs = require('fs');
        this.path = require('path');
        // 팡리 경로 설정 (_env.md)
        this.filePath = this.path.join(app.vault.adapter.basePath, 'doc/_env.md');

        this.data = {};
        this.load();
    }

    // 환경 변수 로드
    load() {
        if (!this.fs.existsSync(this.filePath)) {
            console.error('_env.md 파일을 찾을 수 없습니다.');
            return {};
        }
        
        const content = this.fs.readFileSync(this.filePath, 'utf8');
        content.split('\n').forEach((line) => {
            if (line.trim() && !line.startsWith('#')) {
                const [key, value] = line.split('=');
                if (key && value) {
                    this.data[key.trim()] = value.trim();
                }
            }
        });
    }

    // 현재 데이터를 다시 파일로 저장
    save() {
        try {
            // 객체를 key=value 형식의 문자열로 변환
            const content = Object.entries(this.data)
                .map(([key, value]) => `${key}=${value}`)
                .join('\n');
            
            this.fs.writeFileSync(this.filePath, content, 'utf8');
            return true;
        } catch (error) {
            console.error('Env 저장 중 오류 발생:', error);
            return false;
        }
    }
}

async function loadModule(tp, code, canvas) {
    if (this.env === undefined) {
        this.env = new Env(tp);
    }

    if (this.doc === undefined) {
        this.doc = await new Doc(tp, this.env, code);
    }
}

module.exports = loadModule;